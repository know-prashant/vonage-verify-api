package com.example.vonage.auth.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/")
public class Hello {
    @GetMapping(path="/hello")
    public String hello(){
        return "hello world";
    }
}
