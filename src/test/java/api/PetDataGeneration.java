package api;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Random;

public class PetDataGeneration {
    public static PetsData generateDataPet(String status) {
         PetsData petsData = new PetsData();
         Category category = new Category();
         Tag tag = new Tag();

         petsData.setId(99999920301L);
         petsData.setName(RandomStringUtils.randomAlphabetic(8));
         petsData.setPhotoUrls(Arrays.asList(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(8)));
         category.setId(99999920301L);
         category.setName(RandomStringUtils.randomAlphabetic(8));
         petsData.setCategory(category);
         tag.setId(new Random().nextInt(2030099));
         tag.setName(RandomStringUtils.randomAlphabetic(8));
         petsData.setTags(Arrays.asList(tag));
         petsData.setStatus(status);

        return petsData;
    }

}


