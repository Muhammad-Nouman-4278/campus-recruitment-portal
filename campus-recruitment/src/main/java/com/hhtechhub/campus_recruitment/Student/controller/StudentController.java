package com.hhtechhub.campus_recruitment.Student.controller;

import com.hhtechhub.campus_recruitment.Student.model.StudentProfile;
import com.hhtechhub.campus_recruitment.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<String> registerStudent(@RequestBody StudentProfile profile) {
        String message = studentService.createProfile(profile);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/profile/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> getProfile(@PathVariable String id) {
        return studentService.getProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/profile/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<String> updateProfile(
            @PathVariable String id,
            @RequestBody StudentProfile updatedProfile
    ) {
        String message = studentService.updateProfile(id, updatedProfile);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/upload-resume/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<String> uploadResume(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            String message = studentService.uploadResume(id, file);
            return ResponseEntity.ok(message);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading resume: " + e.getMessage());
        }
    }
}
