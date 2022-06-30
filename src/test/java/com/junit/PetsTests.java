package com.junit;

import api.PetsData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;


public class PetsTests {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI ="https://petstore.swagger.io/v2";
    }
    @Test
    public void getPetByStatusSold(){
        List<PetsData> pets = given()
                .when()
                .contentType(ContentType.JSON)
                .get("/pet/findByStatus?status=sold")
                .then().log().all()
                .extract().response().jsonPath().getList(".", PetsData.class);


        int i =0;

    }

}
