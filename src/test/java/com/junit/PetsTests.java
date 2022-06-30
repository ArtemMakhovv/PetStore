package com.junit;

import api.PetsData;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PetsTests {

    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2")
            .setContentType(ContentType.JSON)
            .build();
    @Test
    public void getPetByStatusSold(){
        List<PetsData> pets = given()
                .spec(REQ_SPEC)
                .when()
                .get("/pet/findByStatus?status=sold")
                .then().log().all()
                .statusCode(200)
                .extract().response().jsonPath().getList(".", PetsData.class);

        pets.forEach((n)-> assertThat("Check that status is equal SOLD", n.getStatus(),is("sold")) );





    }

}
