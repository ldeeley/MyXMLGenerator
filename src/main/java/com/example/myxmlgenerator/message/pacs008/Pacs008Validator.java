package com.example.myxmlgenerator.message.pacs008;

import com.example.myxmlgenerator.cli.config.ConfigProperties;
import com.example.myxmlgenerator.message.generators.ValidatorResponse;
import com.example.myxmlgenerator.message.generators.interfaces.IValidator;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class Pacs008Validator implements IValidator {

    private ConfigProperties configProperties;
    private ValidatorResponse validationResponse;

    public void setConfigProperties(ConfigProperties configProperties)
    {
        this.configProperties=configProperties;
    }
    @Override
    public ValidatorResponse validate(AbstractMX message) {
        validationResponse = new ValidatorResponse();

        validate(message.document().toString() ,getPacs008XSD());
        return validationResponse;
    }

    private String getPacs008XSD() {
        List<HashMap<String, String>> schemas = configProperties.getValidationSchema();
        String result = null;
        for (HashMap<String, String> s: schemas) {
            String message = s.get("Message");
            if (message.equals("00800108"))
                result = s.get("FileName");
        }
        log.info(result);
        return result;
    }

    private void validate(String xmlString, String schemaFile) {

        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            // Guard against XXE injection attacks.
            // See https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.md.
            // Turn on secure processing (FSP), disable all external connections.
            schemaFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            // schemaFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl",true);
            // Disable external entity processing (DTDs) and stylesheet processing
            // Not needed explicitly, handled by FSP, uncomment if customization is needed and provide protocol(s).
            // schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            // schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            // Only allow local file or files in jar to be processed for XML schema files
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "file, jar:file");

            URL xsdResource = getClass().getClassLoader().getResource(schemaFile);
            Schema schema = schemaFactory.newSchema(xsdResource);

            Validator validator = schema.newValidator();
            //validator.validate(new StreamSource(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8))));
            validator.validate(new StreamSource(new StringReader(xmlString)));
            validationResponse.setValid(true);

        } catch (SAXException | IOException e) {
            //e.printStackTrace();
            validationResponse.setValidationResults(e.getMessage());
            validationResponse.setValid(false);
        }
    }

}
