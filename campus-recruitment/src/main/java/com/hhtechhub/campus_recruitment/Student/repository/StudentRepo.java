package com.hhtechhub.campus_recruitment.Student.repository;

import com.hhtechhub.campus_recruitment.Student.model.StudentProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<StudentProfile, String> {
}
