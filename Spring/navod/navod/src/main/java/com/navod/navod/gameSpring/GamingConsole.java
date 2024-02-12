package com.navod.navod.gameSpring;

import com.navod.navod.Game.Game;

public class GamingConsole {
    private com.navod.navod.Game.Game game;
    public GamingConsole(Game game){
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
