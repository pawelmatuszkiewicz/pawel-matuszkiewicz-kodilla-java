package com.kodilla.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share(String post) {
        return "[Facebook Publisher]  " + post;
    }
}
