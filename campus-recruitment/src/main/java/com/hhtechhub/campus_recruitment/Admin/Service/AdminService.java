package com.hhtechhub.campus_recruitment.Admin.Service;



import com.hhtechhub.campus_recruitment.Admin.Model.AdminStatsResponse;
import com.hhtechhub.campus_recruitment.Application.repository.ApplicationRepository;
import com.hhtechhub.campus_recruitment.Recruiter.repository.JobRepository;
import com.hhtechhub.campus_recruitment.Registration.repository.UserRepository;
import com.hhtechhub.campus_recruitment.Registration.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public AdminStatsResponse getDashboardStats() {
        long totalStudents = userRepository.countByRole(Role.STUDENT);
        long totalRecruiters = userRepository.countByRole(Role.RECRUITER);
        long totalJobs = jobRepository.count();
        long totalApplications = applicationRepository.count();

        return new AdminStatsResponse(totalStudents, totalRecruiters, totalJobs, totalApplications);
    }
}
