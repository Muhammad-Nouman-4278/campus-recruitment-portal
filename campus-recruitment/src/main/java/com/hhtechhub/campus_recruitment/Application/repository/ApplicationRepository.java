package com.hhtechhub.campus_recruitment.Application.repository;

import com.hhtechhub.campus_recruitment.Application.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, String> {
    List<Application> findByStudentId(String studentId);
    List<Application> findByJobId(String jobId);
}
