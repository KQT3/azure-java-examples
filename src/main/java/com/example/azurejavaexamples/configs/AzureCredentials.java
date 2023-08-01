package com.example.azurejavaexamples.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AzureCredentials {
    @Value("${azure.serviceURI}")
    private String serviceURI;

    @Value("${azure.primarySecretKey}")
    private String primarySecretKey;
}
