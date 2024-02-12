package com.navod.web.app;

import com.navod.web.app.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}
