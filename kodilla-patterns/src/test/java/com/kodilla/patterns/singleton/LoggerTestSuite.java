package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        //Given
        String operation;
        operation = LocalDateTime.now() + ": operation 1";
        Logger.getLoggerInstance().log(operation);
        operation = LocalDateTime.now() + ": operation 2";
        Logger.getLoggerInstance().log(operation);
        //When
        String result = Logger.getLoggerInstance().getLastLog();
        //Then
        Assert.assertEquals(operation, result);
    }
}
