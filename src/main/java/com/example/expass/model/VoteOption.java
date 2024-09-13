package com.example.expass.model;

public class VoteOption {
    private String voteOptionId;
    private String caption;
    private int presentationOrder;


    public VoteOption(){
        this.voteOptionId = java.util.UUID.randomUUID().toString();
    }


    // Getters and Setters

    public String getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(String voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }
}
