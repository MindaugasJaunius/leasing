package com.homework.leasing.service;

import com.homework.leasing.repository.entity.LeaseStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeasingRulesServiceTest {

    private LeasingRulesService rulesService = new LeasingRulesService();

    @Test
    public void lease_approved_for_min_household_income() {
        assertEquals(LeaseStatus.AUTO_APPROVED,
                rulesService.determineLeaseApplicationStatus(rulesService.minHouseholdIncome));
    }

    @Test
    public void lease_rejected_for_less_than_min_household_income() {
        assertEquals(LeaseStatus.REJECTED,
                rulesService.determineLeaseApplicationStatus(rulesService.minHouseholdIncome.subtract(BigDecimal.ONE)));
    }

    @Test
    public void household_income_sum_of_both_applicants() {
        assertEquals(BigDecimal.ONE.add(BigDecimal.ONE),
                rulesService.countHouseholdIncome(BigDecimal.ONE, Optional.ofNullable(BigDecimal.ONE)));
    }

    @Test
    public void household_income_no_coapplicant() {
        assertEquals(BigDecimal.TEN,
                rulesService.countHouseholdIncome(BigDecimal.TEN, Optional.empty()));
    }

}
