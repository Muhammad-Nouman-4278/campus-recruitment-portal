package com.hhtechhub.campus_recruitment.Application.service;

import com.hhtechhub.campus_recruitment.Application.model.Application;
import com.hhtechhub.campus_recruitment.Application.model.ApplicationStatus;
import com.hhtechhub.campus_recruitment.Application.repository.ApplicationRepository;
import com.hhtechhub.campus_recruitment.Student.model.StudentProfile;

import com.hhtechhub.campus_recruitment.Student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private StudentRepo studentProfileRepository;

    public String apply(Application application) {
        // ✅ Fetch student profile using studentId
        StudentProfile profile = studentProfileRepository.findById(application.getStudentId())
                .orElseThrow(() -> new RuntimeException("jce Student profile not found"));

        // ✅ Auto-fill resumeLink from student profile
        application.setResumeLink(profile.getResumeUrl());
        application.setApplicationStatus(ApplicationStatus.PENDING);
        application.setAppliedAt(java.time.LocalDateTime.now());

        applicationRepository.save(application);
        return "✅ Application submitted successfully.";
    }

    public List<Application> getApplicationsByStudent(String studentId) {
        return applicationRepository.findByStudentId(studentId);
    }

    public List<Application> getApplicationsByJob(String jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    public String updateStatus(String applicationId, ApplicationStatus newStatus) {
        Optional<Application> appOpt = applicationRepository.findById(applicationId);
        if (appOpt.isPresent()) {
            Application app = appOpt.get();
            app.setApplicationStatus(newStatus);
            applicationRepository.save(app);
            return "✅ Status updated to " + newStatus;
        }
        return "❌ Application not found.";
    }
}
