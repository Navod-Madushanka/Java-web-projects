package com.navod.navod.gameSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(Game.class);
        }
    }
}
