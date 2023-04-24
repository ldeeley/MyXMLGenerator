package com.example.myxmlgenerator.cli.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "rapide")
public class ConfigProperties {
    private List<String> purposeCode;
    private List<HashMap<String, String>> currency;
    private List<HashMap<String, String>> validationSchema;
    private int invalidMessageRetry;

    private List<String> sourceBicList;
    private List<String> destinationBicList;

}
