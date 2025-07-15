package com.example.demo.controllers;

import com.example.demo.models.AuthResponse;
import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register) {
        return authService.addNewEmployee(register);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody RegisterDetails login) {
        AuthResponse response = authService.authenticate(login);
        return ResponseEntity.ok(response);
    }
}
