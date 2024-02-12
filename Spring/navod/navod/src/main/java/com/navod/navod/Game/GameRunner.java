package com.navod.navod.Game;

public class GameRunner {
    private Game game;
    public GameRunner(Game game){
        this.game = game;
    }

    public void play(){
        game.play();
    }
    public void up(){
        game.up();
    }
    public void down(){
        game.down();
    }
}
