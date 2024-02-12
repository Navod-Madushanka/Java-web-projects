package com.navod.spring.spring_project_02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.navod.spring.spring_project_02")
public class GamingApp {


    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingApp.class)) {
            context.getBean(Game.class).down();
            context.getBean(GamingConsole.class).pressLeft();
        }

    }
}
