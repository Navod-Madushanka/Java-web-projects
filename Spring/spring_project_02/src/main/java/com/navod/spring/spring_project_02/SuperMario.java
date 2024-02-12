package com.navod.spring.spring_project_02;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperMario implements Game{
    @Override
    public void up() {
        System.out.println("Mario go up");
    }

    @Override
    public void down() {
        System.out.println("Mario go down");
    }

    @Override
    public void right() {
        System.out.println("Mario go Right");
    }

    @Override
    public void left() {
        System.out.println("Mario go Left");
    }
}
