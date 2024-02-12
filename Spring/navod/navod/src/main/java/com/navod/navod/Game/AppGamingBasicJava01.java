package com.navod.navod.Game;

public class AppGamingBasicJava01 {
    public static void main(String[] args) {
        Game game1 = new MarioGame();
        Game game2 = new SuperContra();
        Game game3 = new Pacman();

        GameRunner gameRunner = new GameRunner(game1);
        gameRunner.play();
        gameRunner.up();
        gameRunner.down();
    }
}
