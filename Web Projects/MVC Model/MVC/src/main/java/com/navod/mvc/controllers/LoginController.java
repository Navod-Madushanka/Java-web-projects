package com.navod.mvc.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.jersey.server.mvc.Viewable;

import java.util.HashMap;
import java.util.Map;


@Path("/login")
public class LoginController {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable index(){
        return new Viewable("/login_index");
    }

    @POST
    public Response loginAction(@FormParam("email") String email, @FormParam("password") String password, @Context HttpServletRequest request){
        if(email.equals("user@gmail.com") && password.equals("1234")){
            request.getSession().setAttribute("user", "1");
//            return "redirect:/";
//            return Response.temporaryRedirect(UriBuilder.fromUri("").build()).build();
            return Response.status(Response.Status.FOUND).location(UriBuilder.fromUri("").build()).build();
        }else{
//            return "redirect:/login";
//            return Response.temporaryRedirect(UriBuilder.fromUri("login").build()).build();
            return Response.status(Response.Status.FOUND).location(UriBuilder.fromUri("login").build()).build();
        }
    }
}
