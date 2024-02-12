package com.navod.web.nmshop.util;

import jakarta.servlet.ServletContext;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppUtil {
    private static Map<String, Object> appSetting = new HashMap<>();
    private static ServletContext context;
    public AppUtil(ServletContext context){
        AppUtil.context = context;
    }

    static {
        load();
    }
    private static void load(){
        appSetting.clear();
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = session.createQuery("SELECT app.name, app.value FROM AppSetting app", Object[].class).list();
        list.forEach(o -> {
            appSetting.put(o[0].toString(),o[1].toString());
        });
        session.close();
    }

    public static void reload(){
        load();
    }

    public static String getString(String key){
        return appSetting.get(key).toString();
    }

    public static Object get(String key){
        return appSetting.get(key);
    }

    public static ServletContext getServletContext(){
        return context;
    }
}
