package com.example.expass.model;

import java.time.Instant;

public class Vote {
    private Long voteId;
    private Long userId;
    private Instant publishedAt;
    private Long voteOptionId;
    private Long pollId;


    public Vote(){
    }

    // Getters and Setters


    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Long getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(Long voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }
}
