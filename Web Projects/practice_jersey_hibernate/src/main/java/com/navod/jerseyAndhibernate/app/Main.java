package com.navod.jerseyAndhibernate.app;

import com.navod.jerseyAndhibernate.app.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        Context context = tomcat.addWebapp("/navod", new File(".").getAbsolutePath());
        tomcat.addServlet(context, "a", new ServletContainer(new AppConfig()));
        context.addServletMappingDecoded("/*", "a");
        tomcat.start();
    }
}
