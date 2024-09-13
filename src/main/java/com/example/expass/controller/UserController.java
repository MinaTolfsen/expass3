package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PollManager pollManager;


    // fetch all users
    @GetMapping
    public Collection<User> getAllUsers(){
        return pollManager.getUsers();
    }

    // fetch a single user by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        User user = pollManager.getUserByUsername(username);
        if (user != null){
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    // create a new user
    @PostMapping
    public User createUser(@RequestBody User user){
        String username = user.getUsername();

        if (pollManager.isUserExistByUsername(username)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }

        pollManager.addUser(username, user);
        return user;
    }

    // upadte an existing user
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String  userId, @RequestBody User updateUser){ // maybe change to username
        pollManager.addUser(userId, updateUser);
        return updateUser;
    }

    // delete a user
    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username){ // maybe change to username
        pollManager.removeUser(username);
    }
}
