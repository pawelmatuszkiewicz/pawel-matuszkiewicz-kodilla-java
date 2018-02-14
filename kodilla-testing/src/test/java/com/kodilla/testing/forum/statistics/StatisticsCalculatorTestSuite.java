package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuite {
    @Test
    public void testCalculateAdvStatisticsWhenEmpty() {
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        // Then
        Assert.assertEquals(0, statisticsCalculator.getUsersNumber());
        Assert.assertEquals(0, statisticsCalculator.getPostsNumber());
        Assert.assertEquals(0, statisticsCalculator.getCommentsNumber());
        Assert.assertEquals(new Double(0), (Double) statisticsCalculator.getAvgPostsPerUser());
        Assert.assertEquals(new Double(0), (Double) statisticsCalculator.getAvgCommentsPerPost());
        Assert.assertEquals(new Double(0), (Double) statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsNoPosts() {
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i=0; i<100; i++) {
            usersNames.add("user#" + i);
        }
        int postsNr = 0;
        int commentsNr = 0;
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsNr);
        when(statisticsMock.commentsCount()).thenReturn(commentsNr);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        // Then
        Assert.assertEquals(100, statisticsCalculator.getUsersNumber());
        Assert.assertEquals(0, statisticsCalculator.getPostsNumber());
        Assert.assertEquals(0, statisticsCalculator.getCommentsNumber());
        Assert.assertEquals(new Double(0), (Double) statisticsCalculator.getAvgPostsPerUser());
        Assert.assertEquals(new Double(0), (Double) statisticsCalculator.getAvgCommentsPerUser());
        Assert.assertEquals(new Double(0), (Double) statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsNoComments() {
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i=0; i<100; i++) {
            usersNames.add("user#" + i);
        }
        int postsNr = 1000;
        int commentsNr = 0;
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsNr);
        when(statisticsMock.commentsCount()).thenReturn(commentsNr);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        // Then
        Assert.assertEquals(1000, statisticsCalculator.getPostsNumber());
        Assert.assertEquals(new Double(10), (Double) statisticsCalculator.getAvgPostsPerUser());
        Assert.assertEquals(new Double(0), (Double) statisticsCalculator.getAvgCommentsPerUser());
        Assert.assertEquals(new Double(0), (Double) statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsMorePosts() {
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i=0; i<100; i++) {
            usersNames.add("user#" + i);
        }
        int postsNr = 1000;
        int commentsNr = 300;
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsNr);
        when(statisticsMock.commentsCount()).thenReturn(commentsNr);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        // Then
        Assert.assertEquals(300, statisticsCalculator.getCommentsNumber());
        Assert.assertEquals(new Double(10), (Double) statisticsCalculator.getAvgPostsPerUser());
        Assert.assertEquals(new Double(3), (Double) statisticsCalculator.getAvgCommentsPerUser());
        Assert.assertEquals(new Double(0.3), (Double) statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsMoreComments() {
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i=0; i<100; i++) {
            usersNames.add("user#" + i);
        }
        int postsNr = 1000;
        int commentsNr = 5000;
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsNr);
        when(statisticsMock.commentsCount()).thenReturn(commentsNr);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        // Then
        Assert.assertEquals(new Double(10), (Double) statisticsCalculator.getAvgPostsPerUser());
        Assert.assertEquals(new Double(50), (Double) statisticsCalculator.getAvgCommentsPerUser());
        Assert.assertEquals(new Double(5), (Double) statisticsCalculator.getAvgCommentsPerPost());
    }
}