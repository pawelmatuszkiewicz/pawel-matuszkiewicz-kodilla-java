package com.kodilla.rps;

public class Player {
    private String name;
    private Move move;
    private int score;

    Player(String name) {
        this.name = name;
    }

    public void scores() {
        score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
