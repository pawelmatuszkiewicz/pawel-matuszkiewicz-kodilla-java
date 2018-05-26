package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        // Given
        TaskQueue queue1 = new TaskQueue("John Smith");
        TaskQueue queue2 = new TaskQueue("Kate Greenfield");
        TaskQueue queue3 = new TaskQueue("Melanie Walker");
        Mentor mentor1 = new Mentor("Great Mentor");
        Mentor mentor2 = new Mentor("Bill King");
        queue1.registerObserver(mentor1);
        queue2.registerObserver(mentor2);
        queue3.registerObserver(mentor1);

        // When
        queue1.addExercise("Stream exercise");
        queue2.addExercise("Practise observer pattern");
        queue2.addExercise("Practise Java");
        queue3.addExercise("Implement rest apis");
        queue3.addExercise("Implement db entities");

        // Then
        assertEquals(3, mentor1.getNotifyCount());
        assertEquals(2, mentor2.getNotifyCount());
    }
}
