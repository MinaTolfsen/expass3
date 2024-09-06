package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PollManager pollManager;

    // fetch all users
    @GetMapping
    public Collection<User> getAllUsers(){
        return pollManager.getUsers();
    }

    // fetch a single user by id
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){
        return pollManager.getUser(userId);
    }

    // create a new user
    @PostMapping
    public User createUser(@RequestBody User user){
        pollManager.addUser(user.getUserId(), user);
        return user;
    }

    // upadte an existing user
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updateUser){
        pollManager.addUser(userId, updateUser);
        return updateUser;
    }

    // delete a user
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        pollManager.removeUser(userId);
    }

}
