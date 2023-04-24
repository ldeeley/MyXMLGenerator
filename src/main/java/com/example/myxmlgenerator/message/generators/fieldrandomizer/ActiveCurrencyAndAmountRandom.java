package com.example.myxmlgenerator.message.generators.fieldrandomizer;

import com.example.myxmlgenerator.cli.config.ConfigProperties;
import com.prowidesoftware.swift.model.mx.dic.ActiveCurrencyAndAmount;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActiveCurrencyAndAmountRandom {

    // Assigns random currency
    public static ActiveCurrencyAndAmount getActiveCurrencyAndAmount(ConfigProperties configProperties) {
        ActiveCurrencyAndAmount activeCurrencyAndAmount = new ActiveCurrencyAndAmount();
        activeCurrencyAndAmount.setCcy(Helper.getRandomCurrencyCode(configProperties));
        activeCurrencyAndAmount.setValue(Helper.getLongDigitsRandomNumber(5000,10000000000L));
        return activeCurrencyAndAmount;
    }

    // Assigns currency code for the country provided
    public static ActiveCurrencyAndAmount getActiveCurrencyAndAmount(ConfigProperties configProperties, String countryCode) {
        ActiveCurrencyAndAmount activeCurrencyAndAmount = new ActiveCurrencyAndAmount();
        activeCurrencyAndAmount.setCcy(Helper.getCountryCurrencyCode(configProperties, countryCode));
        activeCurrencyAndAmount.setValue(Helper.getLongDigitsRandomNumber(5000,10000000000L));
        return activeCurrencyAndAmount;
    }
}
