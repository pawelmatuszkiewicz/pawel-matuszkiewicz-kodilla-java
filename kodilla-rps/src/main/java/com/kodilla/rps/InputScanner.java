package com.kodilla.rps;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputScanner {
    private Scanner scanner = new Scanner(System.in);

    public String next() {
        return scanner.next();
    }

    public int nextInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter the number!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String nextStringPattern(Pattern pattern) {
        while (!scanner.hasNext(pattern)) {
            scanner.next();
        }
        return scanner.next();
    }
}
