package com.radha.eurekaclient.controller;

import com.radha.eurekaclient.core.User;
import com.radha.eurekaclient.service.UserService;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Value("${server.port}")
    private int port;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/getById")
    public User getUserById(@QueryParam("userId") Integer userId){
        System.out.println("server port: "+port);
        return userService.findById(userId).get();
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteUserById(@RequestParam Integer userId){
        userService.deleteById(userId);
    }


}
