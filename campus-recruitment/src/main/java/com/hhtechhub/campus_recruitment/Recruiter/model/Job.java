package com.hhtechhub.campus_recruitment.Recruiter.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "jobs")
public class Job {


    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private String companyName;
    private String postedBy; //we will use email here
    private LocalDateTime postedAt;
    private LocalDateTime deadline;

    public Job() {
    }

    public Job(String id, String title, String description, String location, String companyName, String postedBy, LocalDateTime postedAt, LocalDateTime deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.companyName = companyName;
        this.postedBy = postedBy;
        this.postedAt = postedAt;
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
