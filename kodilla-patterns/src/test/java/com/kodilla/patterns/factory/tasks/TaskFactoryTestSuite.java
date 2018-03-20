package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask("SHOPPING_TASK");
        assert shoppingTask != null;
        shoppingTask.executeTask();
        //Then
        Assert.assertEquals("Buy apples", shoppingTask.getTaskName());
        Assert.assertEquals(true, shoppingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.makeTask("PAINTING_TASK");
        assert paintingTask != null;
        paintingTask.executeTask();
        //Then
        Assert.assertEquals("Paint room", paintingTask.getTaskName());
        Assert.assertEquals(true, paintingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask("DRIVING_TASK");
        assert drivingTask != null;
        drivingTask.executeTask();
        //Then
        Assert.assertEquals("Pickup from the airport", drivingTask.getTaskName());
        Assert.assertEquals(true, drivingTask.isTaskExecuted());
    }
}
