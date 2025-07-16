package com.hhtechhub.campus_recruitment.Application.controller;


import com.hhtechhub.campus_recruitment.Application.model.Application;
import com.hhtechhub.campus_recruitment.Application.model.ApplicationStatus;
import com.hhtechhub.campus_recruitment.Application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<String> apply(@RequestBody Application application) {
        return ResponseEntity.ok(applicationService.apply(application));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Application>> getByStudent(@PathVariable String studentId) {
        return ResponseEntity.ok(applicationService.getApplicationsByStudent(studentId));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getByJob(@PathVariable String jobId) {
        return ResponseEntity.ok(applicationService.getApplicationsByJob(jobId));
    }

    // Update application status (Recruiter/Admin)
    @PutMapping("/update-status/{applicationId}/{newStatus}")
    public ResponseEntity<String> updateStatus(
            @PathVariable String applicationId,
            @PathVariable ApplicationStatus newStatus) {
        return ResponseEntity.ok(applicationService.updateStatus(applicationId, newStatus));
    }

}
