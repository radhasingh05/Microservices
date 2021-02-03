package com.radha.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class Controller {

    @Value("${message: Default Hello}")
    private String message;

    @GetMapping("/getMsg")
    public String getMessage(){
        return "Hello User ...."+ message;
    }
}
