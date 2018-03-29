package com.kodilla.rps;

import java.util.regex.Pattern;

public class RpsGame {
    private Player computer;
    private Player player;
    private int roundsToPlay;
    private int currentRoundNr = 1;
    private InputScanner inputScanner = new InputScanner();

    public boolean processGame() {
        initGame();

        boolean end = false;
        while (!end) {
            RpsInfo.printRoundIntro(currentRoundNr);
            switch (inputScanner.nextStringPattern(Pattern.compile("[123xn]"))) {
                case "1":
                    playRound("ROCK");
                    break;
                case "2":
                    playRound("PAPER");
                    break;
                case "3":
                    playRound("SCISSORS");
                    break;
                case "x":
                    System.out.println("Exit the game?  [y/n]");
                    if (inputScanner.nextStringPattern(Pattern.compile("[yn]")).equals("y")) {
                        return true;
                    }
                    break;
                case "n":
                    System.out.println("Start a new game?  [y/n]");
                    if (inputScanner.nextStringPattern(Pattern.compile("[yn]")).equals("y")) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
            end = isOver();
        }

        RpsInfo.printGameResult(player, computer);
        System.out.println("Enter [x] for Exit or [n] for New Game");
        return inputScanner.nextStringPattern(Pattern.compile("[xn]")).equals("x");
    }

    private void initGame() {
        System.out.println("Starting new game...");
        System.out.println("Enter your name: ");
        String username = inputScanner.next();
        System.out.println("Enter the number of round wins needed to complete the game:");
        roundsToPlay = inputScanner.nextInt();

        player = new Player(username);
        computer = new Player("Computer");
        currentRoundNr = 1;
        RpsInfo.printUsage();
    }

    private void playRound(String playerMove) {
        player.setMove(new Move(playerMove));
        computer.setMove(RandomMoveGenerator.drawMove());
        String roundResult = evaluateRound();
        RpsInfo.printRoundResult(player, computer, roundResult);
        currentRoundNr++;
    }

    private String evaluateRound() {

        if (player.getMove().equals(computer.getMove())) {
            return "Tie!";
        } else {
            if (player.getMove().evaluateMove((computer.getMove()))) {
                player.scores();
                return "Great, you win this round!";
            } else {
                computer.scores();
                return  "Computer wins this round.";
            }
        }
    }

    private boolean isOver() {
        return player.getScore() == roundsToPlay || computer.getScore() == roundsToPlay;
    }
}
