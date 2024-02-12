package com.navod.web.nmshop.config;

import com.navod.web.nmshop.util.Encryption;
import com.navod.web.nmshop.util.JwtTokenUtil;
import com.navod.web.nmshop.util.JwtTokenUtilAdmin;
import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DependencyBinder extends AbstractBinder {
    @Override
    protected void configure() {
        System.out.println("Dependency Binder....");
        bind(Encryption.class).to(Encryption.class).in(Singleton.class);
        bind(JwtTokenUtil.class).to(JwtTokenUtil.class).in(Singleton.class);
        bind(JwtTokenUtilAdmin.class).to(JwtTokenUtilAdmin.class).in(Singleton.class);
    }
}
