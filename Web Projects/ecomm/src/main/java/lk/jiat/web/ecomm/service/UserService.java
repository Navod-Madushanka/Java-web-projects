package lk.jiat.web.ecomm.service;

import jakarta.persistence.NoResultException;
import lk.jiat.web.ecomm.entity.User;
import lk.jiat.web.ecomm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {
    public User getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(User.class,id);
    }
    public User getByEmail(String email){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("select u from User u where u.email=:email",User.class).setParameter("email",email).uniqueResult();
        }catch (NoResultException ex){
            return null;
        }
    }

    public void save(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }
}
