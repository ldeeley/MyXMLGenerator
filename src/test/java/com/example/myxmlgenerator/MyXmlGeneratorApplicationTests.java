package com.example.myxmlgenerator;

import com.example.myxmlgenerator.cli.config.ConfigProperties;
import com.example.myxmlgenerator.data.bic.repository.BICRepository;
import com.example.myxmlgenerator.data.lei.repository.LegalEntityRepository;
import com.example.myxmlgenerator.message.pacs008.Pacs008Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.datatype.DatatypeConfigurationException;

@SpringBootTest
class MyXmlGeneratorApplicationTests {

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    Pacs008Message pacs008Message;

    @Autowired
    BICRepository bicRepository;

    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Test
    void contextLoads() {
    }


    @Test
    void checkFieldRandomizer() throws DatatypeConfigurationException {


//        Assertions.assertEquals(pacs008Message.getMessageId().length(),16);

    }


//    @Test
//    void checkConfigProperties() {
//
//        Assertions.assertEquals(10, configProperties.getInvalidMessageRetry());
//        HashMap<String,String> myMap =  configProperties.getValidationSchema().get(0);
//
//        MatcherAssert.assertThat( myMap , IsMapContaining.hasEntry("Message","00800108"));
//        MatcherAssert.assertThat(myMap, IsMapContaining.hasEntry("FileName","pacs.008.001.08.xsd"));
//
//        Assertions.assertEquals(34, configProperties.getPurposeCode().size());
//    }

}
