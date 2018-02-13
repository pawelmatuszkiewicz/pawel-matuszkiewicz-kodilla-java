package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        System.out.println("Test - pierwszy test jednostkowy:");
        Calculator calculator = new Calculator();

        int cresult = calculator.add(22, 77);
        if (cresult == 99) {
            System.out.println("Calculator.add() test OK.");
        }
        else {
            System.out.println("Calculator.add() Error!");
        }

        cresult = calculator.subtract(123, 100);
        if (cresult == 23) {
            System.out.println("Calculator.subtract() test OK.");
        }
        else {
            System.out.println("Calculator.subtract() Error!");
        }
    }
}
