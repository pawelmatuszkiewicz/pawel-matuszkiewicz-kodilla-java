package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        Millenials millenialsUser = new Millenials("john_newman");
        YGeneration yGenerationUser = new YGeneration("black_rider");
        ZGeneration zGenerationUser = new ZGeneration("moonlight_lord");
        //When
        String millenialsSharedPost =  millenialsUser.sharePost("Millenials user post.");
        String yGenerationSharedPost = yGenerationUser.sharePost("Y Generation user post.");
        String zGenerationSharedPost = zGenerationUser.sharePost("Z Generation user post.");
        System.out.println(millenialsSharedPost);
        System.out.println(yGenerationSharedPost);
        System.out.println(zGenerationSharedPost);
        //Then
        Assert.assertEquals("[Facebook Publisher]  Millenials user post.", millenialsSharedPost);
        Assert.assertEquals("[Twitter Publisher]  Y Generation user post.", yGenerationSharedPost);
        Assert.assertEquals("[Snapchat Publisher]  Z Generation user post.", zGenerationSharedPost);

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        ZGeneration zGenerationUser = new ZGeneration("moonlight_lord");
        //When
        String zGenerationSharedPost = zGenerationUser.sharePost("Z Generation user post #1.");
        System.out.println("moonlight_lord posts on: " + zGenerationSharedPost);
        zGenerationUser.setSocialPublisher(new FacebookPublisher());
        zGenerationSharedPost = zGenerationUser.sharePost("Z Generation user post #2.");
        System.out.println("moonlight_lord now posts on: " + zGenerationSharedPost);
        //Then
        Assert.assertEquals("[Facebook Publisher]  Z Generation user post #2.", zGenerationSharedPost);
    }
}
