package com.navod.web.app.service;

import com.navod.web.app.entity.Employee;
import com.navod.web.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeService {
    public Employee getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Employee.class, id);
    }
    public void save(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();
        session.close();
    }
}
