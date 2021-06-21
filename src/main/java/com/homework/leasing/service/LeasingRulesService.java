package com.homework.leasing.service;

import com.homework.leasing.repository.entity.LeaseStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class LeasingRulesService {

    final BigDecimal minHouseholdIncome = new BigDecimal(600);

    public LeaseStatus determineLeaseApplicationStatus(BigDecimal householdIncome) {
        return householdIncome.compareTo(minHouseholdIncome) >= 0 ? LeaseStatus.AUTO_APPROVED : LeaseStatus.REJECTED;
    }

    public BigDecimal countHouseholdIncome(BigDecimal applicantsIncome, Optional<BigDecimal> coApplicantsIncome) {
        return coApplicantsIncome.isPresent() ? applicantsIncome.add(coApplicantsIncome.get()) : applicantsIncome;
    }
}
