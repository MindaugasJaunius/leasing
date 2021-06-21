package com.homework.leasing.service;

import com.homework.leasing.api.model.request.LeasingApplicationRequest;
import com.homework.leasing.api.model.response.LeasingApplicationResponse;
import com.homework.leasing.api.model.response.LeasingApplicationStatusResponse;
import com.homework.leasing.api.model.response.SubmitApplicationResponse;
import com.homework.leasing.repository.LeasingRepository;
import com.homework.leasing.repository.entity.Lease;
import com.homework.leasing.repository.entity.LeaseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeasingService {

    private final LeasingRepository leasingRepository;

    private final LeasingRulesService leasingRules;

    @Autowired
    public LeasingService(LeasingRepository leasingRepository, LeasingRulesService leasingRules) {
        this.leasingRepository = leasingRepository;
        this.leasingRules = leasingRules;
    }

    public SubmitApplicationResponse submit(LeasingApplicationRequest applicationRequest) {
        Lease newLease = new Lease();
        newLease.setSubmissionDate(LocalDateTime.now());

        newLease.setApplicantsEmail(applicationRequest.getApplicantsEmail());
        newLease.setApplicantsPhone(applicationRequest.getApplicantsPhone());
        newLease.setApplicantsPersonalNumber(applicationRequest.getApplicantsPersonalNumber());
        newLease.setApplicantsSalary(applicationRequest.getApplicantsSalary());

        newLease.setCoApplicantsPersonalNumber(applicationRequest.getCoApplicantsPersonalNumber());
        newLease.setCoApplicantsSalary(applicationRequest.getCoApplicantsSalary());

        newLease.setCarVinNumber(applicationRequest.getCarVinNumber());
        newLease.setRequestedAmount(applicationRequest.getRequestedAmount());

        newLease.setStatus(leasingRules.determineLeaseApplicationStatus(
                leasingRules.countHouseholdIncome(applicationRequest.getApplicantsSalary(),
                        Optional.ofNullable(applicationRequest.getCoApplicantsSalary()))));

        Lease savedLease = leasingRepository.save(newLease);

        SubmitApplicationResponse response = new SubmitApplicationResponse();
        response.setApplicationId(savedLease.getId().toString());
        response.setStatus(savedLease.getStatus().name());

        return response;
    }

    public LeasingApplicationResponse fetchApplication(String id) {
        Optional<Lease> lease = leasingRepository.findById(UUID.fromString(id));
        LeasingApplicationResponse response = new LeasingApplicationResponse();
        response.setApplicationId(lease.isPresent() ? lease.get().getId().toString() : "not_found");
        return response;
    }

    public LeasingApplicationStatusResponse fetchApplicationStatus(String id) {
        Optional<Lease> lease = leasingRepository.findById(UUID.fromString(id));
        LeasingApplicationStatusResponse response = new LeasingApplicationStatusResponse();

        if(lease.isPresent()) {
            response.setStatus(lease.get().getStatus().name());
            response.setCarVinNumber(lease.get().getCarVinNumber());
        } else {
            response.setStatus("not_found");
            response.setCarVinNumber("not_found");
        }

        return response;
    }

}
