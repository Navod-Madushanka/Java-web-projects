package com.navod.spring.spring_project_02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GamingConsole {
    private Game game;

    public GamingConsole(@Qualifier("PacmanGameQualifier") Game game){
        this.game = game;
    }
    public void pressUp(){
        game.up();
    }
    public void pressDown(){
        game.down();
    }
    public void pressLeft(){
        game.left();
    }
    public void pressRight(){
        game.right();
    }
}
