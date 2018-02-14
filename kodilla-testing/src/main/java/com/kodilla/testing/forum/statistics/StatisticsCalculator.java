package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    private int usersNumber;
    private int postsNumber;
    private int commentsNumber;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public int getUsersNumber() {
        return usersNumber;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersNumber = statistics.usersNames().size();
        postsNumber = statistics.postsCount();
        commentsNumber = statistics.commentsCount();

        if(usersNumber == 0) {
            avgPostsPerUser = 0;
            avgCommentsPerUser = 0;
        } else {
            avgPostsPerUser = (double) postsNumber/usersNumber;
            avgCommentsPerUser = (double) commentsNumber/usersNumber;
        }

        if(postsNumber == 0) {
            avgCommentsPerPost = 0;
        } else {
            avgCommentsPerPost = (double) commentsNumber/postsNumber;
        }
    }
}
