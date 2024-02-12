package com.navod.web.app.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/login")
public class LoginController {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable index(){
        return new Viewable("/frontend/index");
    }

    @POST
    public String login(){
        return "ok";
    }
}
