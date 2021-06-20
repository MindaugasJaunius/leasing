package com.homework.leasing.service;

import com.homework.leasing.api.model.request.LeasingApplicationRequest;
import com.homework.leasing.api.model.response.LeasingApplicationResponse;
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

    @Autowired
    public LeasingService(LeasingRepository leasingRepository) {
        this.leasingRepository = leasingRepository;
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

        newLease.setStatus(LeaseStatus.PENDING);

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

    public String fetchApplicationStatus(String id) {
        Optional<Lease> lease = leasingRepository.findById(UUID.fromString(id));
        return lease.isPresent() ? lease.get().getStatus().toString() : "not_found";
    }

}
