package com.hhtechhub.campus_recruitment.Student.service;

import com.hhtechhub.campus_recruitment.Student.model.StudentProfile;
import com.hhtechhub.campus_recruitment.Student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    // Save resumes to project-root/uploads/resumes/
    private static final String RESUME_DIR = System.getProperty("user.dir") + "/uploads/resumes";

    public String createProfile(StudentProfile profile) {
        studentRepo.save(profile);
        return "Student profile created successfully.";
    }

    public Optional<StudentProfile> getProfileById(String id) {
        return studentRepo.findById(id);
    }

    public String updateProfile(String id, StudentProfile updatedProfile) {
        Optional<StudentProfile> existingOpt = studentRepo.findById(id);
        if (existingOpt.isEmpty()) {
            return "Student profile not found.";
        }

        StudentProfile existing = existingOpt.get();
        existing.setFullName(updatedProfile.getFullName());
        existing.setDegree(updatedProfile.getDegree());
        existing.setUniversity(updatedProfile.getUniversity());
        existing.setSkills(updatedProfile.getSkills());
        // Don’t update resumeUrl unless explicitly changed
        studentRepo.save(existing);
        return "Profile updated successfully.";
    }

    public String uploadResume(String studentId, MultipartFile file) throws IOException {
        Optional<StudentProfile> optional = studentRepo.findById(studentId);
        if (optional.isEmpty()) {
            return "Student profile not found.";
        }

        // Create directory if it doesn’t exist
        File dir = new File(RESUME_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path destination = Paths.get(RESUME_DIR, filename);
        Files.write(destination, file.getBytes());

        String resumeUrl = "/uploads/resumes/" + filename;

        // Update student profile
        StudentProfile profile = optional.get();
        profile.setResumeUrl(resumeUrl);
        studentRepo.save(profile);

        return "Resume uploaded successfully. URL: " + resumeUrl;
    }
}
