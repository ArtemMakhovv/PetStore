package com.junit;

import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("Проверка питомцев со статусом Available")
public class PetByStatusAvailable {

    private final PetsSteps petsSteps = new PetsSteps();
    @Test
    @Owner("Artem Makhov")
    @DisplayName("Получение питомцев со статусом Available")
    @Description("Найти питомцев по статусу Available. Метод GET. Проверка заголовков, статус ответа и то что все записи имеют статус Available")
    public void getPetByStatusAvailable(){

        List pets = petsSteps.getPetByStatus("available");
        List <String> statuses = petsSteps.getStatuses(pets);
        petsSteps.assertPetsStatus(statuses, Arrays.asList("available"));
    }
}
