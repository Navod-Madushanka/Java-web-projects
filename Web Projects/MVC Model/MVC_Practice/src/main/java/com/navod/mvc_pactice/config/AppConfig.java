package com.navod.mvc_pactice.config;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
    public AppConfig(){
        packages("com.navod.mvc_pactice.controllers");
    }
}
