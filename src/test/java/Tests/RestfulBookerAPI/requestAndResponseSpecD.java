package Tests.RestfulBookerAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class requestAndResponseSpecD {

    public  static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    public static void createRequestAndResponseSpec(){

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(org.selenium.aj34.utils.configReader.readKey("baseURI"))
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();


    }
}
