package com.hhtechhub.campus_recruitment.Security.Service;

import com.hhtechhub.campus_recruitment.Registration.DTO.RegisterRequest;
import com.hhtechhub.campus_recruitment.Registration.model.Role;
import com.hhtechhub.campus_recruitment.Registration.model.User;
import com.hhtechhub.campus_recruitment.Registration.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // ✅ Registration logic
    public String register(RegisterRequest request) {
        // 🔒 Prevent duplicate email
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("❌ Email already in use. Please login or use another email.");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        try {
            Role role = Role.valueOf(request.getRole().toUpperCase());

            // 🔐 Only allow ADMIN role if secret key matches
            if (role == Role.ADMIN) {
                if (request.getSecretKey() == null || !request.getSecretKey().equals("admin2025")) {
                    throw new RuntimeException("❌ Invalid secret key for ADMIN registration.");
                }
            }

            user.setRole(role);

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("❌ Invalid role. Must be STUDENT, RECRUITER, or ADMIN.");
        }

        userRepository.save(user);

        return "✅ Registration successful. Please login.";
    }

    // ✅ Login logic
    public String authenticate(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("❌ User not found."));

        // 🔐 Only return token on successful login
        return jwtService.generateToken(user);
    }
}
