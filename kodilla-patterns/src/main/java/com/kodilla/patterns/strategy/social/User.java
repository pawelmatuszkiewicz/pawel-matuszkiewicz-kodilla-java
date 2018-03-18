package com.kodilla.patterns.strategy.social;

public class User {
    private final String username;
    protected SocialPublisher socialPublisher;

    User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String sharePost(String post) {
        return socialPublisher.share(post);
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
