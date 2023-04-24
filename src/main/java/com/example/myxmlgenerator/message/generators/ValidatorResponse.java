package com.example.myxmlgenerator.message.generators;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ValidatorResponse {
    private String validationResults;
    private boolean valid;
}
