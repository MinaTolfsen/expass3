package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {

    private PollManager pollManager;

   /*@Autowired
    public PollController (PollManager pollManager) {
        this.pollManager = pollManager;
    }*/

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        pollManager.addPoll(poll);
        return poll;
    }

    @GetMapping
    public List<Poll> getAllPolls(){
        return (List<Poll>) pollManager.getAllPolls();
    }

    @DeleteMapping
    public void removePoll(@PathVariable Poll poll){
        pollManager.removePoll(poll);
    }

}
