package com.farheen.ilabsfaqmanagerbackend.initializer;

import com.farheen.ilabsfaqmanagerbackend.model.Role;
import com.farheen.ilabsfaqmanagerbackend.model.User;
import com.farheen.ilabsfaqmanagerbackend.repository.RoleRepo;
import com.farheen.ilabsfaqmanagerbackend.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepo userRepository, RoleRepo roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminRoleName = "ROLE_ADMIN";
            Role adminRole = roleRepository.findByName(adminRoleName);
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setName(adminRoleName);
                roleRepository.save(adminRole);
            }

            String userRoleName = "ROLE_USER";
            Role userRole = roleRepository.findByName(userRoleName);
            if (userRole == null) {
                userRole = new Role();
                userRole.setName(userRoleName);
                roleRepository.save(userRole);
            }

            String adminUsername = "admin";
            if (!userRepository.existsByUsername(adminUsername)) {
                User adminUser = new User();
                adminUser.setUsername(adminUsername);
                adminUser.setPassword(passwordEncoder.encode("admin123")); // Use a secure password in production!
                adminUser.setEmail("admin@gmail.com");
                adminUser.setRole(adminRole);
                userRepository.save(adminUser);
            }
        };
    }
}
