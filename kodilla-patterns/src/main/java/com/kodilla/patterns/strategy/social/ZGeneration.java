package com.kodilla.patterns.strategy.social;

class ZGeneration extends User {
    ZGeneration(String username) {
        super(username);
        this.socialPublisher = new SnapchatPublisher();
    }
}
