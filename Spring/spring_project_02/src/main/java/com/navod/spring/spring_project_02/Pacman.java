package com.navod.spring.spring_project_02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacmanGameQualifier")
public class Pacman implements Game{
    @Override
    public void up() {
        System.out.println("Pacman go up");
    }

    @Override
    public void down() {
        System.out.println("Pacman go down");
    }

    @Override
    public void right() {
        System.out.println("Pacman go Right");
    }

    @Override
    public void left() {
        System.out.println("Pacman go Left");
    }
}
