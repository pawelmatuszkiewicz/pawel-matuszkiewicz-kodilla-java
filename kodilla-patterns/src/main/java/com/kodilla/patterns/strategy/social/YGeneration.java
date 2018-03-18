package com.kodilla.patterns.strategy.social;

class YGeneration extends User {
    YGeneration(String username) {
        super(username);
        this.socialPublisher = new TwitterPublisher();
    }
}
