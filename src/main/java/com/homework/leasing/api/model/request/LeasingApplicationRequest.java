package com.homework.leasing.api.model.request;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LeasingApplicationRequest {

    @Email
    @NotNull
    private String applicantsEmail;

    @NotBlank
    private String applicantsPhone;

    @NotBlank
    private String applicantsPersonalNumber;

    @Digits(integer=7, fraction=2)
    @NotNull
    private BigDecimal applicantsSalary;

    private String coApplicantsPersonalNumber;

    @Digits(integer=7, fraction=2)
    private BigDecimal coApplicantsSalary;

    @NotBlank
    private String carVinNumber;

    @NotNull
    private BigDecimal requestedAmount;


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

}
