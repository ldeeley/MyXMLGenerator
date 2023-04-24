package com.example.myxmlgenerator.message.generators;

import com.example.myxmlgenerator.cli.config.ConfigProperties;
import com.example.myxmlgenerator.data.bic.repository.BICRepository;
import com.example.myxmlgenerator.data.lei.repository.LegalEntityRepository;
import com.example.myxmlgenerator.message.generators.interfaces.IGenerator;
import com.example.myxmlgenerator.message.pacs008.Pacs008Message;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.model.mx.MxPacs00800108;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Pacs008Generator implements IGenerator {

    private LegalEntityRepository legalEntityRepository;
    private BICRepository bicRepository;
    private ConfigProperties configProperties;

    public void setLegalEntityRepository(LegalEntityRepository legalEntityRepository)
    {
        this.legalEntityRepository=legalEntityRepository;
    }

    public void setBICRepository(BICRepository bicRepository)
    {
        this.bicRepository=bicRepository;
    }

    public void setConfigProperties(ConfigProperties configProperties)
    {
        this.configProperties=configProperties;
    }

    @Override
    public List<AbstractMX> generate() {
        List<AbstractMX> messages = new ArrayList();
        try {
            Pacs008Message message = new Pacs008Message();
            MxPacs00800108 mx =  message.generateRandomMessage(legalEntityRepository, bicRepository, configProperties);
            messages.add(mx);

        } catch (Exception e) {
            log.error("Error running Data Loader ", e);
        }

        return messages;
    }
}
