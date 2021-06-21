package com.homework.leasing.api.model.request;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeasingApplicationRequestTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void no_validation_exceptions_present() {
        LeasingApplicationRequest request = new LeasingApplicationRequest();
        request.setApplicantsEmail("value@domain.lt");
        request.setApplicantsPhone("+37000000000");
        request.setApplicantsPersonalNumber("0123456789");
        request.setApplicantsSalary(new BigDecimal("111.11"));
        request.setCoApplicantsPersonalNumber("9876543210");
        request.setCoApplicantsSalary(new BigDecimal("222.22"));
        request.setCarVinNumber("123123123");
        request.setRequestedAmount(new BigDecimal("333.33"));

        assertTrue(validator.validate(request).isEmpty());
    }

    @Test
    public void all_validation_exceptions_present() {
        assertEquals(6, validator.validate(new LeasingApplicationRequest()).size());
    }
}
