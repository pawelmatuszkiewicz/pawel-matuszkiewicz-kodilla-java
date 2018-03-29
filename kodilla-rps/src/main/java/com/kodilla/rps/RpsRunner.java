package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {

        boolean end = false;
        while (!end) {
            RpsGame rpsGame = new RpsGame();
            end = rpsGame.processGame();
        }
        System.out.println("Game over!");
    }
}
