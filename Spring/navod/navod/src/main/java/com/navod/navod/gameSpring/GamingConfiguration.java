package com.navod.navod.gameSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
    public Game game(){
        Game pacman = (Game) new Pacman();
        return pacman;
    }
}
