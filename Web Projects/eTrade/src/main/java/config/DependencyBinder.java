package config;

import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import util.Encryption;

public class DependencyBinder extends AbstractBinder {
    @Override
    protected void configure() {
        System.out.println("Dependency Binder...");
        bind(Encryption.class).to(Encryption.class).in(Singleton.class);
    }
}
