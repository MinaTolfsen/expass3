package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@CrossOrigin
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
    public Poll getPoll(@PathVariable String pollId){
        return pollManager.getPoll(pollId);
    }

    // create a new poll
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        pollManager.addPoll(poll.getPollId(), poll);
        return poll;
    }

    // upadte an existing poll
    @PutMapping("/{pollId}")
    public Poll updatePoll(@PathVariable String pollId, @RequestBody Poll updatePoll){
        pollManager.addPoll(pollId, updatePoll);
        return updatePoll;
    }

    // delete a poll
    @DeleteMapping("/{pollId}")
    public ResponseEntity<String> deletePoll(@PathVariable String pollId){
        pollManager.removePoll(pollId);
        return ResponseEntity.ok("Poll deleted successfully");
    }

    // fetch a poll by question
    @GetMapping("/question/{question}")
    public Poll getPollByQuestion(@PathVariable String question){
        Poll poll = pollManager.getPollByQuestion(question);
        if (poll != null){
            return poll;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Poll not found");
        }
    }
}
