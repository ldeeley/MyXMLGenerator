package com.example.myxmlgenerator.message.generators.interfaces;

import com.example.myxmlgenerator.message.generators.ValidatorResponse;
import com.prowidesoftware.swift.model.mx.AbstractMX;

public interface IValidator {

    ValidatorResponse validate(AbstractMX message);

}
