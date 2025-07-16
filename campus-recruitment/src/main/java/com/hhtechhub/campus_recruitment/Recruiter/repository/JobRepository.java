package com.hhtechhub.campus_recruitment.Recruiter.repository;

import com.hhtechhub.campus_recruitment.Recruiter.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;



public interface JobRepository extends MongoRepository<Job,String> {
        List<Job> findByPostedBy(String recruiterEmail);

}
