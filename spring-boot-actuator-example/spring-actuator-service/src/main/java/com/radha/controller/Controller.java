package com.radha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/act")
public class Controller {

    @GetMapping("/get")
    public String getMessage(){
        return "Welcome to Spring Boot Actuator";

    }
}
