package api;

import io.qameta.allure.Attachment;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;

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
    public Response sendOptionsReq (String path){
        return given()
                .spec(REQ_SPEC)
                .when()
                .options(path)
                .then().extract().response();
    }
    public Response notAllowedPost (String path){
        return given()
                .spec(REQ_SPEC)
                .when()
                .post(path);
    }

    public Response postNewPet (Object pet){
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(pet)
                .post("/pet")
                .then().extract().response();
    }
}
