package com.navod.spring.spring_project_02;

import org.springframework.stereotype.Component;

@Component
public class SuperContra implements Game{
    @Override
    public void up() {
        System.out.println("SuperContra go up");
    }

    @Override
    public void down() {
        System.out.println("SuperContra go down");
    }

    @Override
    public void right() {
        System.out.println("SuperContra go Right");
    }

    @Override
    public void left() {
        System.out.println("SuperContra go Left");
    }
}
