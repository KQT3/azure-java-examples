package com.example.azurejavaexamples;

import com.example.azurejavaexamples.DTOs.ImageDTO;
import com.example.azurejavaexamples.services.CosmosDB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@SpringBootTest
class CosmosDBTests {
    @Autowired
    CosmosDB cosmosDB;

    @Test
    void getItemSuccess() {
        var result = cosmosDB.getItem();
        ANSIColors.printGreen(result);
    }

    @Test
    void getAllItemSuccess() {
        var result = cosmosDB.allItems();
        ANSIColors.printGreen(result);
    }

    @Test
    void addItemSuccess() {
        ImageDTO.ImagesCollection.Image imageId1 = new ImageDTO.ImagesCollection.Image(UUID.randomUUID().toString(), "https://");
        ImageDTO.ImagesCollection.Image imageId2 = new ImageDTO.ImagesCollection.Image(UUID.randomUUID().toString(), "https://");
        ImageDTO.ImagesCollection.Image[] images= {imageId1, imageId2};

        ImageDTO.ImagesCollection imagesCollection = new ImageDTO.ImagesCollection(images, UUID.randomUUID().toString(), CosmosHelperClass.generateDate());
        ImageDTO.ImagesCollection[] imagesCollections= {imagesCollection};
        ImageDTO imageDTO = new ImageDTO(UUID.randomUUID().toString(), UUID.randomUUID().toString(), imagesCollections);
        System.out.println(imageDTO);
        var result = cosmosDB.addItem(imageDTO);
        ANSIColors.printGreen(result);
    }

    @Test
    void generateDateSuccess() {
        String result = CosmosHelperClass.generateDate();
        ANSIColors.printGreen(result);
    }

    @Test
    void UUID() {
        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            ANSIColors.printGreen(uuid);
        }
    }

}
