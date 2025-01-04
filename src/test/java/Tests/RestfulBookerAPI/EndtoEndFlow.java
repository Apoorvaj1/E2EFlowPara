package Tests.RestfulBookerAPI;

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

public class EndtoEndFlow {

    private static RequestSpecification specification;
    private static ResponseSpecification res_specification;
    private String token;
    public int id;
    public List<Integer> bookingIds = new ArrayList<>();

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
    public void createToken() {
        String payload = "{\n" +
                "        \"username\": \"admin\",\n" +
                "        \"password\": \"password123\"\n" +
                "}";

        Response response = given()
                .spec(specification)
                .basePath("/auth")
                .body(payload)
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
    }

    @Test(dependsOnMethods = "createToken",dataProvider = "demoData",dataProviderClass = dataProviderPayload.class)
    public void createBooking(String first,String last){
        String payload = utils.Payload.getPayload(first,last);
        Response response = given().spec(specification).basePath("/booking").cookie("token",token).body(payload).when().post();
        response.getBody().prettyPrint();
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
            Response response = given().spec(specification).basePath("/booking/{ID}").pathParams("ID",id).when().get();
            response.getBody().prettyPrint();
            String checkIn = response.then().extract().path("bookingdates.checkin");
            System.out.println(checkIn);
        }
    }
}
