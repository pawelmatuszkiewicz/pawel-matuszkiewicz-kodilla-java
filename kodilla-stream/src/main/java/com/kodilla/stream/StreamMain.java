package com.kodilla.stream;

//import com.kodilla.stream.beautifier.PoemBeautifier;
//import com.kodilla.stream.iterate.NumbersGenerator;
//import com.kodilla.stream.lambda.*;
//import com.kodilla.stream.reference.FunctionalCalculator;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream\n");

        Forum forum = new Forum();
        Map<Integer, ForumUser> forumUserMap = forum.getUserList().stream()
                .filter(u -> u.getSex() == 'M')
                .filter(u -> u.getPostsNr() >= 1)
                .filter(u -> Period.between(u.getDateOfBirth(), LocalDate.now()).getYears() >= 20)
                .collect(Collectors.toMap(ForumUser::getUserId, u -> u));

        forumUserMap.entrySet().stream()
                .map(entry -> "#" + entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

/*
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
*/

/*      People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

*/
/*
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String strToDecorate = "My wonderful and beautiful poem";
        poemBeautifier.beautify(strToDecorate, s -> s.toUpperCase());
        poemBeautifier.beautify(strToDecorate, s -> "** " + s + " **");

        strToDecorate = "   This is an example text to decorate.   ";
        poemBeautifier.beautify(strToDecorate, s -> "---" + s.trim() + "---");
        poemBeautifier.beautify(strToDecorate, s -> s.replaceAll(" ", "_"));

        System.out.println("\nUsing Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
*/
/*
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);

        Processor processor = new Processor();
        processor.execute(() ->  System.out.println("This is an example text."));

        System.out.println("Calculating expressions with lambdas");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
*/
    }
}
