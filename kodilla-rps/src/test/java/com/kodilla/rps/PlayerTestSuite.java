package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTestSuite {
    @Test
    public void testBeats() {
        // Given
        List<Move> moves = new ArrayList<>();
        moves.add(Move.ROCK);
        moves.add(Move.PAPER);
        moves.add(Move.SCISSORS);
        Player player = new Player("player");
        Player computer = new Player("computer");

        // When
        for (Move playerMove : moves) {
            player.setMove(playerMove);
            for (Move computerMove : moves) {
                computer.setMove(computerMove);
                if (!player.equals(computer)) {
                    if (player.beats(computer)) {
                        player.scores();
                    }
                    else {
                        computer.scores();
                    }
                }
            }
        }
        System.out.println("Player - Computer [" + player.getScore() + " : " + computer.getScore() + "]");

        // Then
        Assert.assertEquals(3, player.getScore());
        Assert.assertEquals(3, computer.getScore());

    }
}
