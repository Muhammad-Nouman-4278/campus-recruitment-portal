package com.hhtechhub.campus_recruitment.Registration.repository;


import com.hhtechhub.campus_recruitment.Registration.model.Role;
import com.hhtechhub.campus_recruitment.Registration.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);

    long countByRole(Role role);

}
