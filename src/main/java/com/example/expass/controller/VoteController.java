package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private PollManager pollManager;


    // fetch all votes
    @GetMapping
    public Collection<Vote> getAllVotes(){
        return pollManager.getVotes();
    }

    // fetch a single vote by id
    @GetMapping("/{voteId}")
    public Vote getVote(@PathVariable Long voteId){
        return pollManager.getVote(voteId);
    }

    // create a new vote
    @PostMapping
    public Vote createVote(@RequestBody Vote vote){
        if (pollManager.isUserExist(vote.getUserId()) && pollManager.isPollExist(vote.getPollId())){
            pollManager.addVote(vote.getVoteId(), vote);
            return vote;
        } else {
            throw new IllegalArgumentException("User or Poll not found");
        }
    }

    // upadte an existing vote
    @PutMapping("/{voteId}")
    public Vote updateVote(@PathVariable Long voteId, @RequestBody Vote updateVote){
        Vote existingVote = pollManager.getVote(voteId);
        if (existingVote != null && existingVote.getUserId().equals(updateVote.getUserId())){
            pollManager.addVote(voteId, updateVote);
            return updateVote;
        } else {
            throw new IllegalArgumentException("Vote not found or User mismatch");
        }
    }

    // delete a vote
    @DeleteMapping("/{voteId}")
    public void deleteVote(@PathVariable Long voteId){
        pollManager.removeVote(voteId);
    }

    // get votes by poll id
    @GetMapping("/poll/{pollId}")
    public List<Vote> getVotesByPollId(@PathVariable Long pollId){
        return pollManager.getVotes().stream().filter(vote -> vote.getPollId().equals(pollId)).toList();
    }
}
