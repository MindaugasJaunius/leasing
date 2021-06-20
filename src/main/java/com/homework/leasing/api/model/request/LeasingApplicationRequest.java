package com.homework.leasing.api.model.request;

import javax.validation.constraints.NotBlank;

public class LeasingApplicationRequest {

    @NotBlank
    private String applicantsEmail;

    public String getApplicantsEmail() {
        return applicantsEmail;
    }

    public void setApplicantsEmail(String applicantsEmail) {
        this.applicantsEmail = applicantsEmail;
    }

}
