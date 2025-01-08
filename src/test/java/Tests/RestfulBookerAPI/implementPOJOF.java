package Tests.RestfulBookerAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.selenium.aj34.utils.dataProviderPayload;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class implementPOJOF {

    private static RequestSpecification specification;
    private static ResponseSpecification res_specification;
    private String token;
    public int id;
    public int price;
    public List<Integer> bookingIds = new ArrayList<>();
    public List<Integer> total_price = new ArrayList<>();

    @BeforeClass
    public void createRequestAndResponseSpecs() {
        specification = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();

        res_specification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void createToken() throws JsonProcessingException {


        ObjectMapper mapper = new ObjectMapper();
        usePOJO pojo = new usePOJO();
        pojo.setUsername("admin");
        pojo.setPassword("password123");
        String json = mapper.writeValueAsString(pojo);


        //usePOJO pojo = new usePOJO("admin","password123");

        Response response = given()
                .spec(specification)
                .basePath("/auth")
                .body(json)
                .when()
                .post();

        // Extract and print all headers
        Headers headers = response.getHeaders();
        for (Header header : headers) {
            System.out.println(header.getName() + ": " + header.getValue());
        }



        // Print response body
        response.getBody().prettyPrint();

        // Extract the token in different ways
        token = response.then().extract().path("token");
        System.out.println("Token is " + token);

        JsonPath jsonPath = response.jsonPath();
        String token1 = jsonPath.getString("token");
        System.out.println("Token is " + token1);

        JsonPath jsonPath1 = new JsonPath(response.asString());
        String token2 = jsonPath1.getString("token");
        System.out.println("Token is " + token2);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        // Validate the response
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
        Assert.assertEquals(response.getHeader("Content-Length"),"27");
        response.then().spec(res_specification);

        authResponse abc = response.as(authResponse.class);
        System.out.println("Token is "+abc.getToken());


        authResponse res = mapper.readValue(response.getBody().asString(),authResponse.class);
        System.out.println("Token res is "+res);

    }

    @Test
    public void getBookingIds(){
        Response response = given().spec(specification).basePath("/booking").when().get();
        response.getBody().prettyPrint();
        JsonPath path = response.jsonPath();
        List<Integer> bookingIds = path.getList("bookingid");
        System.out.println(bookingIds);
        response.then().statusCode(200);
        int id_2nd = bookingIds.get(1);
        System.out.println(id_2nd);
        response.then().body("[0].bookingid",Matchers.greaterThan(10));
        response.then().time(Matchers.lessThan(3000L));
    }

    @Test(dependsOnMethods = "createToken",dataProvider = "demoData",dataProviderClass = dataProviderPayload.class)
    public void createBooking(String first,String last,int totalP) throws JsonProcessingException {
        String payload = utils.Payload.getPayload(first,last,totalP);
        Response response = given().spec(specification).basePath("/booking").cookie("token",token).body(payload).when().post();
        response.getBody().prettyPrint();
        String json = response.getBody().asString();
        ObjectMapper mapper = new ObjectMapper();
        createResponse res = mapper.readValue(json,createResponse.class);
        String firstname = res.getBooking().getFirstname();
        System.out.println("Firstname value is ----------------"+firstname);
        int statusCode1 = response.getStatusCode();
        System.out.println(statusCode1);
        String lastname = response.then().extract().path("booking.lastname");
        System.out.println(lastname);
        JsonPath jsonPath = response.jsonPath();
        id = jsonPath.getInt("bookingid");
        System.out.println(id);
        bookingIds.add(id);
    }

    @Test(dependsOnMethods = "createBooking")
    public void getBooking(){
        for(Integer id:bookingIds){
            Response response = given().spec(specification).basePath("/booking/{ID}").pathParams("ID",id).cookie("token",token).when().get();
            response.getBody().prettyPrint();
            JsonPath jsonPath = new JsonPath(response.asString());
            price = jsonPath.getInt("totalprice");
            System.out.println(price);
            total_price.add(price);
            String checkIn = response.then().extract().path("bookingdates.checkin");
            System.out.println(checkIn);
        }
        int sum =0;
        System.out.println("List value "+total_price);
        for(Integer i:total_price){
            sum = sum+i;
        }
        System.out.println("Sum is "+sum);
    }

    @Test(dependsOnMethods = "getBooking",dataProvider = "demoData1",dataProviderClass = dataProviderPayload.class)
    public void fullUpdateBooking(String first,String last, int totalP,boolean bool){
        for(Integer id:bookingIds){
            Response response = given().spec(specification).basePath("/booking/{ID}").pathParams("ID",id).cookie("token",token).body(utils.Payload.payloadPUT(first,last,totalP,bool)).when().put();
            response.getBody().prettyPrint();
        }
    }

    @Test(dependsOnMethods = "fullUpdateBooking")
    public void deleteBooking(){
        for(Integer id:bookingIds){
            Response response = given().spec(specification).basePath("/booking/{ID}").pathParams("ID",id).cookie("token",token).when().delete();
            int status = response.getStatusCode();
            System.out.println(status);
        }
    }


}
