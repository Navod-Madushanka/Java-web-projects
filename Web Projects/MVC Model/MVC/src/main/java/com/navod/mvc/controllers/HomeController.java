package com.navod.mvc.controllers;

import com.navod.mvc.annotations.IsUser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HomeController {
    @IsUser
    @GET
    public String index(){
        System.out.println("OK");
        return "<h1>Home</h1>";
    }
}
