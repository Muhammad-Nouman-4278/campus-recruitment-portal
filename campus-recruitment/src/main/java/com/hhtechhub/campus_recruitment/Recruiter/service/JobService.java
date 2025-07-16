package com.hhtechhub.campus_recruitment.Recruiter.service;


import com.hhtechhub.campus_recruitment.Recruiter.model.Job;
import com.hhtechhub.campus_recruitment.Recruiter.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class JobService {

    @Autowired
    private JobRepository jobRepo;

    public String postJob(Job job, String recruiterEmail) {
        job.setPostedAt(LocalDateTime.now());              // 🔥 Auto-set current time
        job.setPostedBy(recruiterEmail);                   // 🔥 Auto-set from JWT
        jobRepo.save(job);
        return "✅ Job posted successfully!";
    }

    public List<Job> getJobsByRecruiter(String recruiterEmail) {
        return jobRepo.findByPostedBy(recruiterEmail);
    }

    public Optional<Job> getJobById(String id) {
        return jobRepo.findById(id);
    }

    public String updateJob(String id, Job updatedJob, String recruiterEmail) {
        Optional<Job> jobOpt = jobRepo.findById(id);
        if (jobOpt.isEmpty()) return "Job not found.";

        Job job = jobOpt.get();
        if (!job.getPostedBy().equals(recruiterEmail)) {
            return " Unauthorized to update this job.";
        }

        job.setTitle(updatedJob.getTitle());
        job.setDescription(updatedJob.getDescription());
        job.setLocation(updatedJob.getLocation());
        job.setCompanyName(updatedJob.getCompanyName());
        job.setDeadline(updatedJob.getDeadline());

        jobRepo.save(job);
        return " Job updated successfully.";
    }

    public String deleteJob(String id, String recruiterEmail) {
        Optional<Job> jobOpt = jobRepo.findById(id);
        if (jobOpt.isEmpty()) return " Job not found.";

        Job job = jobOpt.get();
        if (!job.getPostedBy().equals(recruiterEmail)) {
            return " Unauthorized to delete this job.";
        }

        jobRepo.deleteById(id);
        return " Job deleted successfully.";
    }
}

