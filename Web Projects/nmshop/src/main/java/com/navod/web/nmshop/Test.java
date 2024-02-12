package com.navod.web.nmshop;

import com.navod.web.nmshop.entity.AppSetting;
import com.navod.web.nmshop.util.Encryption;
import com.navod.web.nmshop.util.Env;
import com.navod.web.nmshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        String encrypt = Encryption.encrypt("Navod");
//        System.out.println(encrypt);

//        System.out.println(Env.get("mail.host"));
        AppSetting appSetting = new AppSetting();
        appSetting.setName("app_description");
        appSetting.setValue("ETrade is a e-commerce web application");
        Transaction transaction = session.beginTransaction();
        session.persist(appSetting);
        transaction.commit();

    }
}
