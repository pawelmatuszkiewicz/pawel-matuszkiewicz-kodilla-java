package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MoveTestSuite {
    @Test
    public void testEvaluateMove() {
        // Given
        List<Move> moves = new ArrayList<>();
        moves.add(new Move("ROCK"));
        moves.add(new Move("PAPER"));
        moves.add(new Move("SCISSORS"));
        int wins = 0;
        int losses = 0;
        //When
        for (Move move1 : moves) {
            for (Move move2 : moves) {
                if (move1 != move2) {
                    if (move1.evaluateMove(move2)) {
                        wins++;
                    } else {
                        losses++;
                    }
                }
            }
        }
        //Then
        Assert.assertEquals(3, wins);
        Assert.assertEquals(3, losses);
    }
}
