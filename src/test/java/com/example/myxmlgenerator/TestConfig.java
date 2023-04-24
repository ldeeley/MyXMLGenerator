package com.example.myxmlgenerator;

import com.example.myxmlgenerator.cli.config.ConfigProperties;
import com.example.myxmlgenerator.message.pacs008.Pacs008Message;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public ConfigProperties configProperties() {
        return new ConfigProperties();
    }

    @Bean
    public Pacs008Message pacs008Message(){
        return new Pacs008Message();
    }



}
