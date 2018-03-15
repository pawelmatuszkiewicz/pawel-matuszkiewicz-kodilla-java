package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getToDoList().addTask("To do task");
        board.getInProgressList().addTask("In progress task");
        board.getDoneList().addTask("Done task");
        //When
        String task1 = board.getToDoList().getTasks().get(0);
        String task2 = board.getInProgressList().getTasks().get(0);
        String task3 = board.getDoneList().getTasks().get(0);

        System.out.println("==== To do list: ==== >>");
        board.getToDoList().getTasks().forEach(System.out::println);
        System.out.println("<< ==== To do list ====");
        System.out.println("==== In progress list: ==== >>");
        board.getInProgressList().getTasks().forEach(System.out::println);
        System.out.println("<< ==== In progress list ====");
        System.out.println("==== Done list: ==== >>");
        board.getDoneList().getTasks().forEach(System.out::println);
        System.out.println("<< ==== Done list ====");

        //Then
        Assert.assertEquals("To do task", task1);
        Assert.assertEquals("In progress task", task2);
        Assert.assertEquals("Done task", task3);
    }
}
