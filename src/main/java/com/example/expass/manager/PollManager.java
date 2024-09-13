package com.example.expass.manager;

import com.example.expass.model.Poll;
import com.example.expass.model.User;
import com.example.expass.model.Vote;
import com.example.expass.model.VoteOption;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PollManager {
    private Map<String, Poll> polls = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    private Map<String, VoteOption> voteOptions = new HashMap<>();
    private Map<String, Vote> votes = new HashMap<>();


    // methods to manage Users
    public void addUser(String userId, User user){
        users.put(userId, user);
    }

    public User getUser(String userId){
        return users.get(userId);
    }

    public User getUserByUsername(String username){
        return users.values().stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    public void removeUser(String userId){
        users.remove(userId);
    }


    // methods to manage Polls
    public void addPoll(String pollId, Poll poll){
        List<VoteOption> voteOptions = poll.getVoteOptions();
        if (voteOptions != null && !voteOptions.isEmpty()){
            for (VoteOption option : voteOptions){
                option.setVoteOptionId(UUID.randomUUID().toString());
                addVoteOption(option.getVoteOptionId(), option);
            }
        }
        polls.put(pollId, poll);
    }

    public Poll getPoll(String pollId){
        return polls.get(pollId);
    }

    public void removePoll(String pollId){
        polls.remove(pollId);
        votes.entrySet().removeIf(entry -> entry.getValue().getPollId().equals(pollId));
    }

    public Poll getPollByQuestion(String question){
        return polls.values().stream().filter(poll -> poll.getQuestion().equals(question)).findFirst().orElse(null);
    }


    // methods to manage Vote
    public void addVote(String voteId, Vote vote){
        votes.put(voteId, vote);
    }

    public Vote getVote(String voteId){
        return votes.get(voteId);
    }

    public void removeVote(String voteId){
        votes.remove(voteId);
    }

    public List<Vote> getVotesByPoll(String pollId){
        return votes.values().stream().filter(vote -> vote.getPollId().equals(pollId)).collect(Collectors.toList());
    }

    public Vote getVoteByUserAndPoll(String username, String pollId){
        return votes.values().stream().filter(vote -> vote.getUsername().equals(username) && vote.getPollId().equals(pollId)).findFirst().orElse(null);
    }

    public void updateVote(String voteId, Vote vote){
        votes.put(voteId, vote);
    }


    // methods to manage VoteOption
    public void addVoteOption(String voteOptionId, VoteOption voteOption){
        voteOptions.put(voteOptionId, voteOption);
    }

    public VoteOption getVoteOption(String voteOptionId){
        return voteOptions.get(voteOptionId);
    }

    public void removeVoteOption(String voteOptionId){
        voteOptions.remove(voteOptionId);
    }


    // collection methods to fetch all users, polls, votes and voteOptions
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
    public boolean isUserExistByUsername(String username){
        return users.values().stream().anyMatch(user -> user.getUsername().equals(username));
    }

    public boolean isPollExist(String pollId){
        return polls.containsKey(pollId);
    }
}
