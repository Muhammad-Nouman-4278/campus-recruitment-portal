package com.hhtechhub.campus_recruitment.Application.model;

import java.time.LocalDateTime;

public class ApplicationResponse {
    private String id;
    private String jobId;
    private String resumeLink;
    private String applicationStatus;
    private LocalDateTime appliedAt;
    private String studentName;

    // Constructors
    public ApplicationResponse() {
    }

    public ApplicationResponse(String id, String jobId, String resumeLink, String applicationStatus, LocalDateTime appliedAt, String studentName) {
        this.id = id;
        this.jobId = jobId;
        this.resumeLink = resumeLink;
        this.applicationStatus = applicationStatus;
        this.appliedAt = appliedAt;
        this.studentName = studentName;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
