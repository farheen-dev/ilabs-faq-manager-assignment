package com.farheen.ilabsfaqmanagerbackend.service;

import com.farheen.ilabsfaqmanagerbackend.dto.LoginDTO;
import com.farheen.ilabsfaqmanagerbackend.dto.UserDTO;
import com.farheen.ilabsfaqmanagerbackend.response.LoginResponse;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
}
