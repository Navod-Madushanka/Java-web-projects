package com.navod.web.nmshop.service;

import com.navod.web.nmshop.dto.RegisterDTO;
import com.navod.web.nmshop.entity.User;
import com.navod.web.nmshop.util.Encryption;
import com.navod.web.nmshop.util.HibernateUtil;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;
import java.util.UUID;

public class UserService {
    public User getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(User.class, id);
    }
    public Optional<User> getByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();;
        try {
            return session.createQuery("select u from User u where u.email=:email", User.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();
        } catch (NoResultException ex) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }
    public void save(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    public User registerUser(RegisterDTO registerDTO){
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(Encryption.encrypt(registerDTO.getPassword()));

        String verificationCode = UUID.randomUUID().toString();
        user.setVerification_code(verificationCode);

        save(user);

        return user;
    }
}
