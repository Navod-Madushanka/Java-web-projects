package com.navod.jerseyAndhibernate.app.config;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
    public AppConfig(){
        packages("com.navod.jerseyAndhibernate.app.controller");
    }
}
