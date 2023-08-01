package com.example.azurejavaexamples;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public interface CosmosHelperClass {

    static String generateDate() {
        Instant instant = Instant.now();
        LocalDateTime localDateTime = instant.atZone(ZoneOffset.UTC).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return localDateTime.format(formatter);
    }
}
