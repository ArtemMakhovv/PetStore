package com.junit;

import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;



public class PetByStatusSold {

    private final PetsSteps petsSteps = new PetsSteps();
    @Test
    @Owner("Artem Makhov")
    @DisplayName("Получение питомцев со статусом SOLD")
    @Description("Найти питомцев по статусу SOLD. Метод GET. Проверка заголовков, статус ответа и то что все записи имеют статус sold")
    public void getPetByStatusSold(){

        List pets = petsSteps.getPetByStatus("sold");
        List <String> statuses = petsSteps.getStatuses(pets);
        petsSteps.assertPetsStatus(statuses, "sold");

    }

}
