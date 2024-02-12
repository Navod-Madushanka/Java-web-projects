package com.navod.web.nmshop.service;

import com.navod.web.nmshop.entity.SignUpImage;
import com.navod.web.nmshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class AppSettingService {
    public SignUpImage getSignUpTitleImageById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(SignUpImage.class, id);
    }

    public void saveSignUpImage(SignUpImage signUpImage){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(signUpImage);
        transaction.commit();
        session.close();
    }

    public SignUpImage getLastTitle(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (SignUpImage) session.createQuery("FROM SignUpImage si ORDER BY si.id DESC")
                .setMaxResults(1).uniqueResult();

    }
}
