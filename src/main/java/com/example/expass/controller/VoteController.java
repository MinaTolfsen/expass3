package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.Poll;
import com.example.expass.model.Vote;
import com.example.expass.model.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
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
    public Vote getVote(@PathVariable String voteId){
        Vote vote = pollManager.getVote(voteId);
        if (vote == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vote not found");
        }
        return vote;
    }

    // create a new vote
    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        String username = vote.getUsername();
        String question = vote.getQuestion();
        String caption = vote.getCaption();

        // Find the poll by question
        Poll poll = pollManager.getPollByQuestion(question);

        if (poll != null) {
            // Check if the poll has the specified caption
            boolean validCaption = poll.getVoteOptions().stream()
                    .anyMatch(option -> option.getCaption().equals(caption));

            if (!validCaption) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid vote option");
            }

            // Check if the user exists
            if (pollManager.isUserExistByUsername(username)) {
                // Check if the vote already exists for this user and poll
                Vote existingVote = pollManager.getVoteByUserAndPoll(username, poll.getPollId());
                if (existingVote != null) {
                    // Update existing vote
                    existingVote.setCaption(vote.getCaption());
                    existingVote.setPublishedAt(vote.getPublishedAt());
                    pollManager.updateVote(existingVote.getVoteId(), existingVote);
                    return existingVote;
                } else {
                    // Create a new vote
                    vote.setPollId(poll.getPollId());
                    vote.setVoteId(UUID.randomUUID().toString());
                    pollManager.addVote(vote.getVoteId(), vote);
                    return vote;
                }
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Poll not found");
        }
    }




    // upadte an existing vote
    @PutMapping("/{voteId}")
    public Vote updateVote(@PathVariable String voteId, @RequestBody Vote vote){
        Vote existingVote = pollManager.getVote(voteId);
        if (existingVote != null && existingVote.getUsername().equals(vote.getUsername())){
            pollManager.addVote(voteId, vote);
            return vote;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vote does not exist or username does not exist");
        }

    }

    // delete a vote
    @DeleteMapping("/{voteId}")
    public void deleteVote(@PathVariable String voteId){
        pollManager.removeVote(voteId);
    }

    // get votes by poll id
    @GetMapping("/poll/{pollId}")
    public List<Vote> getVotesByPollId(@PathVariable String pollId){
        return pollManager.getVotesByPoll(pollId);
    }
}
