package com.navod.jersey.app.config;

import com.navod.jersey.app.service.UserService;
import com.navod.jersey.app.util.JwtTokenUnit;
import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DependencyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        System.out.println("DependancyBinder.....");
        bind(JwtTokenUnit.class).to(JwtTokenUnit.class).in(Singleton.class);
        bind(UserService.class).to(UserService.class).in(Singleton.class);
    }
}
