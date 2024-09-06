package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollManager pollManager;

    // fetch all polls
    @GetMapping
    public Collection<Poll> getAllPolls(){
        return pollManager.getPolls();
    }

    // fetch a single poll by id
    @GetMapping("/{pollId}")
    public Poll getPoll(@PathVariable Long pollId){
        return pollManager.getPoll(pollId);
    }

    // create a new poll
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        if (pollManager.isUserExist(poll.getUserId())){
            pollManager.addPoll(poll.getPollId(), poll);
            return poll;
        } else {
            throw new IllegalArgumentException("User does not exist");
        }
    }

    // upadte an existing poll
    @PutMapping("/{pollId}")
    public Poll updatePoll(@PathVariable Long pollId, @RequestBody Poll updatePoll){
        pollManager.addPoll(pollId, updatePoll);
        return updatePoll;
    }

    // delete a poll
    @DeleteMapping("/{pollId}")
    public ResponseEntity<String> deletePoll(@PathVariable Long pollId){
        pollManager.removePoll(pollId);
        return ResponseEntity.ok("Poll deleted successfully");
    }

}
