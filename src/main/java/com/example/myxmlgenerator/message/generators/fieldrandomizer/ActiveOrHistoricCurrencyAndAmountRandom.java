package com.example.myxmlgenerator.message.generators.fieldrandomizer;

import com.example.myxmlgenerator.cli.config.ConfigProperties;
import com.prowidesoftware.swift.model.mx.dic.ActiveOrHistoricCurrencyAndAmount;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;

@Slf4j
public class ActiveOrHistoricCurrencyAndAmountRandom {

    public static ActiveOrHistoricCurrencyAndAmount getActiveOrHistoricCurrencyAndAmount(BigDecimal settleAmount, String currency)
    {
        ActiveOrHistoricCurrencyAndAmount activeOrHistoricCurrencyAndAmount = new ActiveOrHistoricCurrencyAndAmount();
        SecureRandom random = new SecureRandom();
        BigDecimal fxRate = BigDecimal.valueOf(10 + random.nextInt(90));
        activeOrHistoricCurrencyAndAmount.setCcy(currency);
        //applying FX
        activeOrHistoricCurrencyAndAmount.setValue((settleAmount.subtract(fxRate)).setScale(2, RoundingMode.CEILING));
        return activeOrHistoricCurrencyAndAmount;
    }

    // Assigns random currency
    public static ActiveOrHistoricCurrencyAndAmount getActiveOrHistoricCurrencyAndAmount(ConfigProperties configProperties)
    {
        ActiveOrHistoricCurrencyAndAmount activeOrHistoricCurrencyAndAmount = new ActiveOrHistoricCurrencyAndAmount();
        activeOrHistoricCurrencyAndAmount.setCcy(Helper.getRandomCurrencyCode(configProperties));
        activeOrHistoricCurrencyAndAmount.setValue(Helper.getLongDigitsRandomNumber(5000,10000000000L));
        return activeOrHistoricCurrencyAndAmount;
    }

    // Assigns currency for the country code provided
    public static ActiveOrHistoricCurrencyAndAmount getActiveOrHistoricCurrencyAndAmount(ConfigProperties configProperties,
                                                                                         String countryCode)
    {
        ActiveOrHistoricCurrencyAndAmount activeOrHistoricCurrencyAndAmount = new ActiveOrHistoricCurrencyAndAmount();
        activeOrHistoricCurrencyAndAmount.setCcy(Helper.getCountryCurrencyCode(configProperties, countryCode));
        activeOrHistoricCurrencyAndAmount.setValue(Helper.getLongDigitsRandomNumber(5000,10000000000L));
        return activeOrHistoricCurrencyAndAmount;
    }
}
