package com.navod.navod.Game;

public class Pacman implements Game{
    @Override
    public void play() {
        System.out.println("Play Pacman");
    }

    @Override
    public void up() {
        System.out.println("Jump Pacman");
    }

    @Override
    public void down() {
        System.out.println("Cruel Pacman");
    }
}
