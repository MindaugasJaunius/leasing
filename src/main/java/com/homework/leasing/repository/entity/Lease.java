package com.homework.leasing.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Lease {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime submissionDate;

    private String applicantsEmail;

    private String applicantsPhone;

    private String applicantsPersonalNumber;

    private BigDecimal applicantsSalary;

    private String coApplicantsPersonalNumber;

    private BigDecimal coApplicantsSalary;

    private String carVinNumber;

    private BigDecimal requestedAmount;

    private LeaseStatus status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getApplicantsEmail() {
        return applicantsEmail;
    }

    public void setApplicantsEmail(String applicantsEmail) {
        this.applicantsEmail = applicantsEmail;
    }

    public String getApplicantsPhone() {
        return applicantsPhone;
    }

    public void setApplicantsPhone(String applicantsPhone) {
        this.applicantsPhone = applicantsPhone;
    }

    public String getApplicantsPersonalNumber() {
        return applicantsPersonalNumber;
    }

    public void setApplicantsPersonalNumber(String applicantsPersonalNumber) {
        this.applicantsPersonalNumber = applicantsPersonalNumber;
    }

    public BigDecimal getApplicantsSalary() {
        return applicantsSalary;
    }

    public void setApplicantsSalary(BigDecimal applicantsSalary) {
        this.applicantsSalary = applicantsSalary;
    }

    public String getCoApplicantsPersonalNumber() {
        return coApplicantsPersonalNumber;
    }

    public void setCoApplicantsPersonalNumber(String coApplicantsPersonalNumber) {
        this.coApplicantsPersonalNumber = coApplicantsPersonalNumber;
    }

    public BigDecimal getCoApplicantsSalary() {
        return coApplicantsSalary;
    }

    public void setCoApplicantsSalary(BigDecimal coApplicantsSalary) {
        this.coApplicantsSalary = coApplicantsSalary;
    }

    public String getCarVinNumber() {
        return carVinNumber;
    }

    public void setCarVinNumber(String carVinNumber) {
        this.carVinNumber = carVinNumber;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public LeaseStatus getStatus() {
        return status;
    }

    public void setStatus(LeaseStatus status) {
        this.status = status;
    }

}
