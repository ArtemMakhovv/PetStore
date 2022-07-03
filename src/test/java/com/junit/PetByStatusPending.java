package com.junit;

import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


@DisplayName("Проверка питомцев со статусом Pending")
public class PetByStatusPending {

    private final PetsSteps petsSteps = new PetsSteps();
    @Test
    @Owner("Artem Makhov")
    @DisplayName("Получение питомцев со статусом Pending")
    @Description("Найти питомцев по статусу Pending. Метод GET. Проверка заголовков, статус ответа и то что все записи имеют статус Pending")
    public void getPetByStatusPending(){

        List pets = petsSteps.getPetByStatus("pending");
        List <String> statuses = petsSteps.getStatuses(pets);
        petsSteps.assertPetsStatus(statuses, Arrays.asList("pending"));

    }
}
