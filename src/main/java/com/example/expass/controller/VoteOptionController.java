package com.example.expass.controller;

import com.example.expass.manager.PollManager;
import com.example.expass.model.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/voteOptions")
public class VoteOptionController {

    @Autowired
    private PollManager pollManager;


    // fetch all voteOptions
    @GetMapping
    public Collection<VoteOption> getAllVoteOptions(){
        return pollManager.getVoteOptions();
    }

    // fetch a single voteOption by id
    @GetMapping("/{voteOptionId}")
    public VoteOption getVoteOption(@PathVariable Long voteOptionId){
        return pollManager.getVoteOption(voteOptionId);
    }

    // create a new voteOption
    @PostMapping
    public VoteOption createVoteOption(@RequestBody VoteOption voteOption){
        pollManager.addVoteOption(voteOption.getVoteOptionId(), voteOption);
        return voteOption;
    }

    // upadte an existing voteOption
    @PutMapping("/{voteOptionId}")
    public VoteOption updateVoteOption(@PathVariable Long voteOptionId, @RequestBody VoteOption updateVoteOption){
        pollManager.addVoteOption(voteOptionId, updateVoteOption);
        return updateVoteOption;
    }

    // delete a voteOption
    @DeleteMapping("/{voteOptionId}")
    public void deleteVoteOption(@PathVariable Long voteOptionId){
        pollManager.removeVoteOption(voteOptionId);
    }
}
