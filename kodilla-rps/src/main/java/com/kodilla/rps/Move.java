package com.kodilla.rps;

import java.util.Objects;

public class Move {
    private static final String ROCK = "ROCK";
    private static final String PAPER = "PAPER";
    private static final String SCISSORS = "SCISSORS";
    private String move;

    Move(String move) {
        if (move.equals(ROCK) || move.equals(PAPER) || move.equals(SCISSORS)) {
            this.move = move;
        } else {
            throw new IllegalStateException("Move should be ROCK, PAPER or SCISSORS");
        }
    }

    public boolean evaluateMove(Move anotherMove) {
        switch (move) {
            case ROCK:
                return anotherMove.move.equals(SCISSORS);
            case PAPER:
                return anotherMove.move.equals(ROCK);
            case SCISSORS:
                return anotherMove.move.equals(PAPER);
            default:
                return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move1 = (Move) o;
        return Objects.equals(move, move1.move);
    }

    @Override
    public String toString() {
        return move;
    }
}
