package com.homework.leasing.api.model.response;

public class LeasingApplicationResponse {

    private String submissionDate;

    private String applicantsEmail;

    private String applicantsPhone;

    private String applicantsPersonalNumber;

    private String applicantsSalary;

    private String coApplicantsPersonalNumber;

    private String coApplicantsSalary;

    private String carVinNumber;

    private String requestedAmount;

    private String status;

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
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

    public String getApplicantsSalary() {
        return applicantsSalary;
    }

    public void setApplicantsSalary(String applicantsSalary) {
        this.applicantsSalary = applicantsSalary;
    }

    public String getCoApplicantsPersonalNumber() {
        return coApplicantsPersonalNumber;
    }

    public void setCoApplicantsPersonalNumber(String coApplicantsPersonalNumber) {
        this.coApplicantsPersonalNumber = coApplicantsPersonalNumber;
    }

    public String getCoApplicantsSalary() {
        return coApplicantsSalary;
    }

    public void setCoApplicantsSalary(String coApplicantsSalary) {
        this.coApplicantsSalary = coApplicantsSalary;
    }

    public String getCarVinNumber() {
        return carVinNumber;
    }

    public void setCarVinNumber(String carVinNumber) {
        this.carVinNumber = carVinNumber;
    }

    public String getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(String requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
