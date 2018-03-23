package com.kodilla.rps;

import java.util.regex.Pattern;

public class RpsRunner {
    enum GameStage {NEW_GAME, GAME_IN_PROGRESS, GAME_OVER}

    public static void main(String[] args) {

        RpsGame rpsGame = new RpsGame();
        boolean end = false;
        int currentRoundNr = 1;
        GameStage gameStage = GameStage.NEW_GAME;
        InputScanner inputScanner = new InputScanner();

        while (!end) {
            switch (gameStage) {
                case NEW_GAME:
                    System.out.println("Starting new game...");
                    System.out.println("Enter your name: ");
                    String username = inputScanner.next();
                    System.out.println("Enter the number of round wins needed to complete the game:");
                    int roundsToPlay = inputScanner.nextInt();

                    rpsGame = new RpsGame(new Player("Computer"), new Player(username), roundsToPlay);
                    RpsInfo.printUsage();
                    currentRoundNr = 1;
                    gameStage = GameStage.GAME_IN_PROGRESS;
                    break;

                case GAME_IN_PROGRESS:
                    RpsInfo.printRoundIntro(currentRoundNr);
                    String roundResult = "";

                    switch (inputScanner.nextStringPattern(Pattern.compile("[123xn]"))) {
                        case "1":
                            rpsGame.getPlayer().setMove(Move.ROCK);
                            rpsGame.getComputer().setMove(RandomMoveGenerator.drawMove());
                            roundResult = rpsGame.playRound();
                            break;
                        case "2":
                            rpsGame.getPlayer().setMove(Move.PAPER);
                            rpsGame.getComputer().setMove(RandomMoveGenerator.drawMove());
                            roundResult = rpsGame.playRound();
                            break;
                        case "3":
                            rpsGame.getPlayer().setMove(Move.SCISSORS);
                            rpsGame.getComputer().setMove(RandomMoveGenerator.drawMove());
                            roundResult = rpsGame.playRound();
                            break;
                        case "x":
                            System.out.println("Exit the game?  [y/n]");
                            if (inputScanner.nextStringPattern(Pattern.compile("[yn]")).equals("y")) {
                                end = true;
                                continue;
                            } else {
                                continue;
                            }
                        case "n":
                            System.out.println("Start a new game?  [y/n]");
                            if (inputScanner.nextStringPattern(Pattern.compile("[yn]")).equals("y")) {
                                gameStage = GameStage.NEW_GAME;
                                continue;
                            } else {
                                continue;
                            }
                        default:
                            break;
                    }

                    RpsInfo.printRoundResult(rpsGame.getPlayer(), rpsGame.getComputer(), roundResult);
                    if (rpsGame.isOver()) {
                        gameStage = GameStage.GAME_OVER;
                    }
                    currentRoundNr++;
                    break;

                case GAME_OVER:
                    RpsInfo.printGameResult(rpsGame.getPlayer(), rpsGame.getComputer());
                    System.out.println("Enter [x] for Exit or [n] for New Game");
                    if (inputScanner.nextStringPattern(Pattern.compile("[xn]")).equals("x")) {
                        end = true;
                    } else {
                        gameStage = GameStage.NEW_GAME;
                    }
                    break;
            }
        }
        System.out.println("Game over!");
    }
}
