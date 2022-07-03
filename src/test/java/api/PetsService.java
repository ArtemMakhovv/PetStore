package api;

import io.qameta.allure.Attachment;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetsService {

    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2")
            .setContentType(ContentType.JSON)
            .addHeader("api_key", "special-key")
            .build();

    public Response getPetsByStatus(String status) {
            return given()
                    .spec(REQ_SPEC)
                    .when()
                    .get("/pet/findByStatus?status="+addSeveralStatus(status))
                    .then().extract().response();
    }

    private String addSeveralStatus (String status){
        if (status.contains(",")) {
            status.replace(",", "&status=");
            return status;
        }
        else {
            return status;
        }
    }
}
