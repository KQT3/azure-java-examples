package com.example.azurejavaexamples.services;

import com.example.azurejavaexamples.configs.AzureCredentials;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class CosmosDB {
    private AzureCredentials azureCredentials;

    public void createItem() {
        System.out.println("createItem");
    }
}
