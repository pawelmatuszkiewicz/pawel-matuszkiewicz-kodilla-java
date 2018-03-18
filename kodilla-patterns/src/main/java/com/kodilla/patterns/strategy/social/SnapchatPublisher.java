package com.kodilla.patterns.strategy.social;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share(String post) {
        return "[Snapchat Publisher]  " + post;
    }
}
