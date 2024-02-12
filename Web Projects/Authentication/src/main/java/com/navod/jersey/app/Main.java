package com.navod.jersey.app;

import com.navod.jersey.app.config.AppConfig;
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
        Context context = tomcat.addWebapp("/jersey", new File("./src/main/webapp").getAbsolutePath());
        context.setAllowCasualMultipartParsing(true); // to enable multipart request

//        tomcat.addServlet(context, "a", new ServletContainer(new AppConfig()));
//        context.addServletMappingDecoded("/*", "a");

        tomcat.start();
    }
}
