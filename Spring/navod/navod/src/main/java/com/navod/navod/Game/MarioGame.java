package com.navod.navod.Game;

public class MarioGame implements Game{
    @Override
    public void play() {
        System.out.println("Play Mario");
    }
    public void up(){
        System.out.println("Jump Mario");
    }
    public void down(){
        System.out.println("Cruel Mario");
    }
}
