package com.hhtechhub.campus_recruitment.Recruiter.controller;



import com.hhtechhub.campus_recruitment.Recruiter.model.Job;
import com.hhtechhub.campus_recruitment.Recruiter.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiter/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/post-job")
    public ResponseEntity<String> postJob(
            @RequestBody Job job,
            Authentication authentication
    ) {
        String recruiterEmail = authentication.getName();
        String message = jobService.postJob(job, recruiterEmail);
        return ResponseEntity.ok(message);
    }


    @GetMapping("/my-jobs")
    public ResponseEntity<List<Job>> getMyJobs(Authentication auth) {
        return ResponseEntity.ok(jobService.getJobsByRecruiter(auth.getName()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJob(@PathVariable String id, @RequestBody Job job, Authentication auth) {
        return ResponseEntity.ok(jobService.updateJob(id, job, auth.getName()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable String id, Authentication auth) {
        return ResponseEntity.ok(jobService.deleteJob(id, auth.getName()));
    }
}
