package com.example.expass.manager;

import com.example.expass.model.Poll;
import com.example.expass.model.User;
import com.example.expass.model.Vote;
import com.example.expass.model.VoteOption;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
    private Map<Long, Poll> polls = new HashMap<>();
    private Map<Long, User> users = new HashMap<>();
    private Map<Long, VoteOption> voteOptions = new HashMap<>();
    private Map<Long, Vote> votes = new HashMap<>();


    // methods to manage Users
    public void addUser(Long userId, User user){
        users.put(userId, user);
    }

    public User getUser(Long userId){
        return users.get(userId);
    }

    public void removeUser(Long userId){
        users.remove(userId);
    }


    // methods to manage Polls
    public void addPoll(Long pollId, Poll poll){
        polls.put(pollId, poll);
    }

    public Poll getPoll(Long pollId){
        return polls.get(pollId);
    }

    public void removePoll(Long pollId){
        polls.remove(pollId);
        votes.entrySet().removeIf(entry -> entry.getValue().getPollId().equals(pollId));
    }


    // methods to manage Vote
    public void addVote(Long voteId, Vote vote){
        votes.put(voteId, vote);
    }

    public Vote getVote(Long voteId){
        return votes.get(voteId);
    }

    public void removeVote(Long voteId){
        votes.remove(voteId);
    }


    // methods to manage VoteOption
    public void addVoteOption(Long voteOptionId, VoteOption voteOption){
        voteOptions.put(voteOptionId, voteOption);
    }

    public VoteOption getVoteOption(Long voteOptionId){
        return voteOptions.get(voteOptionId);
    }

    public void removeVoteOption(Long voteOptionId){
        voteOptions.remove(voteOptionId);
    }


    // convenience methods to fetch all users, polls, votes and voteOptions
    public Collection<User> getUsers() {
        return users.values();
    }

    public Collection<Poll> getPolls() {
        return polls.values();
    }

    public Collection<VoteOption> getVoteOptions() {
        return voteOptions.values();
    }

    public Collection<Vote> getVotes() {
        return votes.values();
    }


    // additional methods
    public boolean isUserExist(Long userId){
        return users.containsKey(userId);
    }

    public boolean isPollExist(Long pollId){
        return polls.containsKey(pollId);
    }
}
