package com.navod.mvc.controllers;

import com.navod.mvc.annotations.IsUser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
@IsUser
@Path("/user")
public class UserController {
    @GET()
    @Path("/{id}")
    public String get(@PathParam("id") Long id){
        return id.toString();
    }
}
