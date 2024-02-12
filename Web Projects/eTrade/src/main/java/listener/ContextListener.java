package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import provider.MailServiceProvider;
import util.AppUtil;
import util.Env;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("BASE_URL", servletContext.getContextPath()+"/");
        servletContext.setAttribute("App", new AppUtil(servletContext));

        System.out.println("servlet context Initialized");
        Env.getProperties().put("app_url","http://localhost:8080"+servletContext.getContextPath());
        MailServiceProvider.getInstance().start();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MailServiceProvider.getInstance().shutDown();
    }
}
