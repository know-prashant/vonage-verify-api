package com.example.vonage.auth.controllers;

import com.example.vonage.auth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("api/login")
public class Auth {

    @Autowired
    AuthService authService;

    @PostMapping(path="/init", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String init(@NotBlank String identifier){
        return authService.init(identifier);
    }

    @PostMapping(path="/verify", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String verify(@NotBlank String identifier, @NotBlank String request_id, @NotBlank String otp){
        return authService.verify(identifier, request_id, otp);
    }
}
