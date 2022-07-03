package com.junit;

import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("Проверка питомцев со статусом SOLD, PENDING, AVAILABLE")
public class PetByStatusAll {

    private final PetsSteps petsSteps = new PetsSteps();
    @Test
    @Owner("Artem Makhov")
    @DisplayName("Получение питомцев со статусом SOLD, PENDING, AVAILABLE")
    @Description("Найти питомцев по статусу SOLD, PENDING, AVAILABLE. Метод GET. Проверка заголовков, статус ответа и то что все записи имеют статус SOLD, PENDING, AVAILABLE")
    public void getPetByStatusAll(){

        List pets = petsSteps.getPetByStatus("sold,available,pending");
        List <String> statuses = petsSteps.getStatuses(pets);
        petsSteps.assertPetsStatus(statuses, Arrays.asList("available", "pending", "sold"));
        petsSteps.assertPetsSeveralStatus(statuses, "available");
        petsSteps.assertPetsSeveralStatus(statuses, "pending");
        petsSteps.assertPetsSeveralStatus(statuses, "sold");

    }
}
