package com.junit;

import api.PetsData;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class PetsTests {
    private final static String URL = "https://petstore.swagger.io/v2";
    @Test
    public void getPetByStatusSold(){
        List<PetsData> pets = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"/pet/findByStatus?status=sold")
                .then().log().all()
                .extract().response().jsonPath().getList(".", PetsData.class);

    }

}
