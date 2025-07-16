package com.hhtechhub.campus_recruitment.Student.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "student_profiles")
public class StudentProfile{

    @Id
    private String id;

    private String fullName;
    private String degree;
    private String university;
    private List<String> skills;
    private String resumeUrl;

    public StudentProfile() {}

    public StudentProfile(String id, String fullName, String degree, String university,
                          List<String> skills, String resumeUrl) {
        this.id = id;
        this.fullName = fullName;
        this.degree = degree;
        this.university = university;
        this.skills = skills;
        this.resumeUrl = resumeUrl;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
}
