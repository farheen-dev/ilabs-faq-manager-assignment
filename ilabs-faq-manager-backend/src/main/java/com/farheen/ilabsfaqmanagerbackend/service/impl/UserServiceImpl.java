package com.farheen.ilabsfaqmanagerbackend.service.impl;

import com.farheen.ilabsfaqmanagerbackend.dto.LoginDTO;
import com.farheen.ilabsfaqmanagerbackend.dto.UserDTO;
import com.farheen.ilabsfaqmanagerbackend.model.Role;
import com.farheen.ilabsfaqmanagerbackend.model.User;
import com.farheen.ilabsfaqmanagerbackend.repository.RoleRepo;
import com.farheen.ilabsfaqmanagerbackend.response.LoginResponse;
import com.farheen.ilabsfaqmanagerbackend.repository.UserRepo;
import com.farheen.ilabsfaqmanagerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        Role userRole = roleRepo.findByName("ROLE_USER");
        User user = new User(
                userDTO.getUserid(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword()),
                userRole
        );
        userRepo.save(user);
        return user.getUsername();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByUsername(loginDTO.getUsername());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password not Match", false);
            }
        }else {
            return new LoginResponse("Username not exits", false);
        }
    }
}
