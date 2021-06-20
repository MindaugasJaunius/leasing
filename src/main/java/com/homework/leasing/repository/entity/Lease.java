package com.homework.leasing.repository.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Lease {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime submissionDate;

    private String applicantsEmail;

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

    public LeaseStatus getStatus() {
        return status;
    }

    public void setStatus(LeaseStatus status) {
        this.status = status;
    }

}
