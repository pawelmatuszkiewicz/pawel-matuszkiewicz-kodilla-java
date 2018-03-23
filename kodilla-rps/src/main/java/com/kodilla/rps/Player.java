package com.kodilla.rps;

enum Move { ROCK, PAPER, SCISSORS }

public class Player {
    private String name;
    private Move move;
    private int score;

    Player(String name) {
        this.name = name;
    }

    public boolean beats(Player other) {
        switch (move) {
            case ROCK:
                return other.getMove() == Move.SCISSORS;
            case PAPER:
                return other.getMove() == Move.ROCK;
            case SCISSORS:
                return other.getMove() == Move.PAPER;
            default:
                return false;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return move == player.move;
    }
}
