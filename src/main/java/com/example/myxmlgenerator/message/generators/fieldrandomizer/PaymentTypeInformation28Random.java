package com.example.myxmlgenerator.message.generators.fieldrandomizer;

import com.example.myxmlgenerator.cli.config.ConfigProperties;
import com.prowidesoftware.swift.model.mx.dic.CategoryPurpose1Choice;
import com.prowidesoftware.swift.model.mx.dic.PaymentTypeInformation28;
import com.prowidesoftware.swift.model.mx.dic.Priority2Code;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.List;

@Slf4j
public class PaymentTypeInformation28Random {

    public static PaymentTypeInformation28 getPaymentTypeInformation28(ConfigProperties configProperties)
    {
        PaymentTypeInformation28 paymentTypeInformation = new PaymentTypeInformation28();

        CategoryPurpose1Choice categoryPurpose = new CategoryPurpose1Choice();
        List<String> purposeCodes = configProperties.getPurposeCode();
        SecureRandom random = new SecureRandom();
        int index = random.nextInt(purposeCodes.size());
        categoryPurpose.setCd(purposeCodes.get(index));
        paymentTypeInformation.setCtgyPurp(categoryPurpose);

        index = random.nextInt( Priority2Code.values().length);
        paymentTypeInformation.setInstrPrty(Priority2Code.values()[index]);

        return paymentTypeInformation;
    }
}
