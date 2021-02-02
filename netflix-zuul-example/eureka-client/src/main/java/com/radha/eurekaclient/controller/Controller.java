package com.radha.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class Controller {

    @GetMapping("/getMsg")
    public String getMessage(){
        return "Hello User ....";
    }
}
