package com.navod.navod.Game;

public class SuperContra implements Game{
    @Override
    public void play() {
        System.out.println("Play SuperContra");
    }

    @Override
    public void up() {
        System.out.println("Jump SuperContra");
    }

    @Override
    public void down() {
        System.out.println("cruel SuperContra");
    }
}
