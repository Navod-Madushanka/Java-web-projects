package com.navod.jersey.app.config;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
    public AppConfig(){
        packages("com.navod.jersey.app.controller");
        packages("com.navod.jersey.app.middleware");
        register(DependencyBinder.class);
    }
}
