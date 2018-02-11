package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTestSuite {
    String testCaseName;

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end (" + testCaseName + ")");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        testCaseName = "Odd Numbers Exterminator Empty List Test";
        // When
        int size = oddNumbersExterminator.exterminate(numbers).size();
        System.out.println("Testing empty list.");
        // Then
        Assert.assertEquals(0, size);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        // Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(13);
        numbers.add(8);
        numbers.add(22);
        numbers.add(100);
        numbers.add(55);
        numbers.add(6);
        numbers.add(81);
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        testCaseName = "Odd Numbers Exterminator Normal List Test";
        // When
        ArrayList<Integer> evenNumbers = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing normal list.");
        // Then
        Assert.assertEquals(new Integer(4), evenNumbers.get(0));
        Assert.assertEquals(new Integer(8), evenNumbers.get(1));
        Assert.assertEquals(new Integer(22), evenNumbers.get(2));
        Assert.assertEquals(new Integer(100), evenNumbers.get(3));
        Assert.assertEquals(new Integer(6), evenNumbers.get(4));
        Assert.assertEquals(5, evenNumbers.size());

    }
}
