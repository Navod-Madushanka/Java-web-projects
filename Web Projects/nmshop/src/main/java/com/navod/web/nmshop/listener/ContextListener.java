package com.navod.web.nmshop.listener;

import com.navod.web.nmshop.provider.MailServiceProvider;
import com.navod.web.nmshop.util.AppUtil;
import com.navod.web.nmshop.util.Env;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("BASE_URL", context.getContextPath()+"/");
        context.setAttribute("admin_assets", context.getContextPath()+"/admin/assets");
        context.setAttribute("App", new AppUtil(context));

        System.out.println("Context initialized");
        Env.getProperties().put("app_url","http://localhost:8080"+context.getContextPath());
        MailServiceProvider.getInstance().start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MailServiceProvider.getInstance().shutdown();
    }
}
