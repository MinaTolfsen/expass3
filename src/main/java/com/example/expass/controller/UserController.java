package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private PollManager pollManager;

    @PostMapping
    public User createUser(@RequestBody User user){
        pollManager.addUser(user);
        return user;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return (List<User>) pollManager.getAllUsers();
    }
}
