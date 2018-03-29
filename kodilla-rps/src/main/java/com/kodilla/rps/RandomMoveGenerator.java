package com.kodilla.rps;

import java.util.Random;

public class RandomMoveGenerator {
    private static Random randomGenerator = new Random();

    public static Move drawMove() {
        int n = randomGenerator.nextInt(3);
        if(n == 0) {
            return new Move("ROCK");
        } else if(n == 1) {
            return new Move("PAPER");
        } else {
            return new Move("SCISSORS");
        }
    }
}
