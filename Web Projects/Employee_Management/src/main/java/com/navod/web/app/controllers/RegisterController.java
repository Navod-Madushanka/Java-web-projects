package com.navod.web.app.controllers;

import com.navod.web.app.entity.Employee;
import com.navod.web.app.util.HibernateUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

@Path("/register")
public class RegisterController {
    @GET
    public Viewable index(){
        System.out.println("ela");
        return new Viewable("/frontend/register");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void register(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setDepartment(employee.getDepartment());
        newEmployee.setPosition(employee.getPosition());
        newEmployee.setSalary(employee.getSalary());
        session.persist(newEmployee);
        session.close();
    }
}
