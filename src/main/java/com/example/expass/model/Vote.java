package com.example.expass.model;

import java.time.Instant;
import java.util.UUID;

public class Vote {
    private String voteId;
    private String username;
    private String caption;
    private String pollId;
    private Instant publishedAt;
    private String question; // Add a question field


    public Vote(){
        this.voteId = UUID.randomUUID().toString();
    }


    // Getters and Setters


    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
