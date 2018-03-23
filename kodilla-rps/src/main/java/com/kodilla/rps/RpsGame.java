package com.kodilla.rps;


public class RpsGame {
    private Player computer;
    private Player player;
    private int roundsToPlay;

    RpsGame(Player computer, Player player, int roundsToPlay) {
        this.computer = computer;
        this.player = player;
        this.roundsToPlay = roundsToPlay;
    }

    RpsGame() {
    }

    public String playRound() {

        if (player.equals(computer)) {
            return "Tie!";
        } else {
            if (player.beats(computer)) {
                player.scores();
                return "Great, you win this round!";
            } else {
                computer.scores();
                return  "Computer wins this round.";
            }
        }
    }

    public boolean isOver() {
        return player.getScore() == roundsToPlay || computer.getScore() == roundsToPlay;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }
}
