package api;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PetsSteps extends PetsService {

    @Step ("Получить питомцев по status = {status}")
    @Attachment
    public List<PetsData> getPetByStatus(String status) {
        Response response = getPetsByStatus(status);
        assertSCodeAndHeaders(200, response);
        return response.jsonPath().getList(".", PetsData.class);
    }

    @Step ("Получение списка статусов для всех питомцев")
    @Attachment
    public List<String> getStatuses(List<PetsData> pets) {
        List<String> statuses = new ArrayList<>();
        pets.forEach(n-> statuses.add(n.getStatus()));
        return statuses;
    }
    @Step ("Проверка что все найденные питомцы имеют корректный статус {status}")
    public PetsSteps assertPetsStatus(List<String> statuses, String status){
    assertThat("Check that status is equal {status} for every Items", statuses, everyItem(is(status)));
    return this;
    }
    @Step ("Проверка что статус код ответа {expectedStatusCode}")
    public void assertSCodeAndHeaders(Integer expectedStatusCode, Response response) {
        assertThat("Check that response status code equals {expectedStatusCode}", response.statusCode(), equalTo(expectedStatusCode));
        assertThat("Check header access-control-allow-headers",response.getHeader("access-control-allow-headers"), equalTo("Content-Type, api_key, Authorization"));
        assertThat("Check header access-control-allow-methods",response.getHeader("access-control-allow-methods"), equalTo("GET, POST, DELETE, PUT"));
        assertThat("Check header content-type",response.getHeader("content-type"), equalTo("application/json"));

    }
}
