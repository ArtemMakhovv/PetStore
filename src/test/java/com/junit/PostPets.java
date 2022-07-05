package com.junit;

import api.PetDataGeneration;
import api.PetsData;
import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Проверки создания нового питомца")
public class PostPets {

    private final PetsSteps petsSteps = new PetsSteps();
    private final PetsData dataOfPet = PetDataGeneration.generateDataPet("sold");

    @Test
    @Owner("Artem Makhov")
    @DisplayName("Добавление нового питомца с валидными данными")
    @Description("Добавление нового питомца с валидными данными. Метод POST. Проверка тела ответа и поиск новой записи")
    public void postValidNewPet(){

        PetsData body = petsSteps.crateNewPet(dataOfPet);
        petsSteps.assertPetBody(body,dataOfPet);
        PetsData petById = petsSteps.getPetById(body.getId());
        petsSteps.assertPetBody(petById, dataOfPet);

    }


}
