package com.example.azurejavaexamples.services;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.example.azurejavaexamples.DTOs.ImageDTO;
import com.example.azurejavaexamples.configs.AzureCredentials;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class CosmosDB {
    private AzureCredentials azureCredentials;

    public ImageDTO getItem() {
        CosmosClient cosmosClient = createCosmosClient(azureCredentials.getServiceURI(), azureCredentials.getPrimarySecretKey());

        String databaseId = "chaincue";
        String containerId = "user_images";
        String userId = "ec8e3d53-5b88-438e-8187-4d4aacdebb04";

        CosmosDatabase cosmosDatabase = cosmosClient.getDatabase(databaseId);
        CosmosContainer cosmosContainer = cosmosDatabase.getContainer(containerId);

        String query = "SELECT * FROM c WHERE c.id = '" + userId + "'";
        var queryOptions = new CosmosQueryRequestOptions();

        var items = cosmosContainer.queryItems(query, queryOptions, ImageDTO.class);

        return items.stream().findFirst().orElse(null);
    }

    public List<ImageDTO> allItems() {
        CosmosClient cosmosClient = createCosmosClient(azureCredentials.getServiceURI(), azureCredentials.getPrimarySecretKey());

        String databaseId = "chaincue";
        String containerId = "user_images";

        CosmosDatabase cosmosDatabase = cosmosClient.getDatabase(databaseId);
        CosmosContainer cosmosContainer = cosmosDatabase.getContainer(containerId);

        String query = "SELECT * FROM c";
        var queryOptions = new CosmosQueryRequestOptions();

        var items = cosmosContainer.queryItems(query, queryOptions, ImageDTO.class);

        return items.stream().collect(Collectors.toList());
    }

    public List<ImageDTO> addItem(ImageDTO newItem) {
        String databaseId = "chaincue";
        String containerId = "user_images";
        CosmosClient cosmosClient = createCosmosClient(azureCredentials.getServiceURI(), azureCredentials.getPrimarySecretKey());

        CosmosDatabase cosmosDatabase = cosmosClient.getDatabase(databaseId);
        CosmosContainer cosmosContainer = cosmosDatabase.getContainer(containerId);

        cosmosContainer.createItem(newItem);

        String query = "SELECT * FROM c";
        var queryOptions = new CosmosQueryRequestOptions();
        var items = cosmosContainer.queryItems(query, queryOptions, ImageDTO.class);
        return items.stream().collect(Collectors.toList());
    }

    private static CosmosClient createCosmosClient(String endpoint, String key) {
        return new CosmosClientBuilder()
                .endpoint(endpoint)
                .key(key)
                .buildClient();
    }
}
