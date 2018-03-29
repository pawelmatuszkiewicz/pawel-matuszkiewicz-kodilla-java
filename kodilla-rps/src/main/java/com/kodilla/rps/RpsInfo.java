package com.kodilla.rps;

public class RpsInfo {

    static void printUsage() {
        System.out.println("USAGE:");
        System.out.println("Enter 1 for ROCK");
        System.out.println("Enter 2 for PAPER");
        System.out.println("Enter 3 for SCISSORS");
        System.out.println("Enter x for Exit");
        System.out.println("Enter n for New Game\n");
    }

    static void printRoundIntro(int roundNr) {
        System.out.println("------ Round #" + roundNr + "------");
        System.out.println("\tMake a move: [1] - ROCK, [2] - PAPER," +
                " [3] - SCISSORS      [x] - Exit, [n] - New game");
    }

    static void printRoundResult(final Player player, final Player computer, final String result) {
        System.out.println("\t" + player.getName() + " - " + computer.getName());
        System.out.println("\t" + player.getMove() + " - " + computer.getMove());
        System.out.println("\t" + player.getScore() + " - " + computer.getScore());
        System.out.println("\t" + result + "\n");
    }

    static void printGameResult(final Player player, final Player computer) {
        System.out.println("|----------- Game Result -----------");
        System.out.println("\t" + player.getName() + " " + player.getScore()
                + " : " + computer.getScore() + " " + computer.getName());
        if (player.getScore() > computer.getScore()) {
            System.out.println("Congratulations! You won the game.");
        } else {
            System.out.println("\tComputer won the game.");
        }
        System.out.println("-----------------------------------|\n");
    }
}
