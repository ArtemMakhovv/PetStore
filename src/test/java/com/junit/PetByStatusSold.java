package com.junit;

import api.PetsData;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PetByStatusSold {

    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2")
            .setContentType(ContentType.JSON)
            .build();
    @Test
    @Owner("Artem Makhov")
    @DisplayName("Получение питомцев со статусом SOLD")
    @Description("Найти питомцев по статусу SOLD. Метод GET. Проверка заголовков, статус ответа и то что все записи имеют статус sold")
    public void getPetByStatusSold(){
        List<PetsData> pets = given()
                .spec(REQ_SPEC)
                .when()
                .get("/pet/findByStatus?status=sold")
                .then()
                .statusCode(200)
                .header("access-control-allow-headers", "Content-Type, api_key, Authorization")
                .header("access-control-allow-methods", "GET, POST, DELETE, PUT")
                .header("content-type", "application/json")
                .extract().response().jsonPath().getList(".", PetsData.class);

        List<String> status = new ArrayList<>();
        pets.forEach(n-> status.add(n.getStatus()));
        assertThat("Check that status is equal SOLD for every Items", status, everyItem(is("sold")));





    }

}
