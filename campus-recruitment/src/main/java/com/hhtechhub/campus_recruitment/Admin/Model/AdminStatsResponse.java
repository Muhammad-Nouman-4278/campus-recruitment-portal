package com.hhtechhub.campus_recruitment.Admin.Model;


public class AdminStatsResponse {
    private long totalStudents;
    private long totalRecruiters;
    private long totalJobs;
    private long totalApplications;

    public AdminStatsResponse() {
    }

    public AdminStatsResponse(long totalStudents, long totalRecruiters, long totalJobs, long totalApplications) {
        this.totalStudents = totalStudents;
        this.totalRecruiters = totalRecruiters;
        this.totalJobs = totalJobs;
        this.totalApplications = totalApplications;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public long getTotalRecruiters() {
        return totalRecruiters;
    }

    public void setTotalRecruiters(long totalRecruiters) {
        this.totalRecruiters = totalRecruiters;
    }

    public long getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(long totalJobs) {
        this.totalJobs = totalJobs;
    }

    public long getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }
}
