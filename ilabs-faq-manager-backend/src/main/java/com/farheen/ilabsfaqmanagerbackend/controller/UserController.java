package com.farheen.ilabsfaqmanagerbackend.controller;

import com.farheen.ilabsfaqmanagerbackend.dto.LoginDTO;
import com.farheen.ilabsfaqmanagerbackend.dto.UserDTO;
import com.farheen.ilabsfaqmanagerbackend.response.LoginResponse;
import com.farheen.ilabsfaqmanagerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/signUp")
    public String saveUser(@RequestBody UserDTO userDTO){
         String id = userService.addUser(userDTO);
         return id;
    }

    @PostMapping(path = "/signIn")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
