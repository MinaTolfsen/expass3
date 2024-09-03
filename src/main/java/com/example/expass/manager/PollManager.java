package com.example.expass.manager;

import com.example.expass.model.Poll;
import com.example.expass.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PollManager {
    private HashMap<Integer, Poll> polls = new HashMap<>();
    private HashMap<Integer, User> users = new HashMap<>();


    public PollManager() {
    }


    // Method to poll
    public  void addPoll(Poll poll){
        polls.put(poll.getPollId(), poll);
    }

    public Poll getPoll(Poll poll){
        return polls.get(poll.getPollId());
    }

    public void removePoll(Poll poll){
        polls.remove(poll.getPollId());
    }

    public boolean pollExists(Poll poll){
        return polls.containsKey(poll.getPollId());
    }


    // Method to user
    public void addUser(User user){
        users.put(user.getUserId(), user);
    }

    public User getUser(User user){
        return users.get(user.getUserId());
    }

    public void removeUser(User user){
        users.remove(user.getUserId());
    }

    public boolean userExists(User user){
        return users.containsKey(user.getUserId());
    }


    // Get all Polls and Users

    public HashMap<Integer, Poll> getAllPolls(){
        return polls;
    }

    public HashMap<Integer, User> getAllUsers(){
        return users;
    }
}
