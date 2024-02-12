package com.navod.web.nmshop.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/my-account")
public class UserAccountSettings {
    @Context
    HttpSession session;
    @GET
    public Viewable index(){
        Object userId = session.getAttribute("user");
        System.out.println(userId.toString());
        return new Viewable("/frontend/my-account");
    }
}
