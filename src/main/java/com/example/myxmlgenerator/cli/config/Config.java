package com.example.myxmlgenerator.cli.config;

import com.example.myxmlgenerator.data.bic.repository.BICRepository;
import com.example.myxmlgenerator.data.lei.repository.LegalEntityRepository;
import com.example.myxmlgenerator.message.generators.Pacs008Generator;
import com.example.myxmlgenerator.message.pacs008.Pacs008Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Autowired
    private LegalEntityRepository legalEntityRepository;

    @Autowired
    private BICRepository bicRepository;

    @Autowired
    private ConfigProperties configProperties;


    @Bean
    public Pacs008Generator getPacs008Generator() {
        var entity = new Pacs008Generator();
        entity.setLegalEntityRepository(legalEntityRepository);
        entity.setBICRepository(bicRepository);
        entity.setConfigProperties(configProperties);

        return entity;
    }

    @Bean
    public Pacs008Validator getPacs008Validator() {
        var entity = new Pacs008Validator();
        entity.setConfigProperties(configProperties);
        return entity;
    }

}
