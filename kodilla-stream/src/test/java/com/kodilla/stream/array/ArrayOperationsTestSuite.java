package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        // Given
        int[] numbers = {2,5,3,9,12,7,10,18,4,20,13,5,17,33,6,23,14,8,9,1};
        // When
        double average = ArrayOperations.getAverage(numbers);
        // Then
        Assert.assertEquals(10.95, average, 0);
    }
}
