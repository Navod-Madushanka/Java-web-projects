package com.navod.jerseyAndhibernate.app.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HomeController {
    @GET
    public String index(){
        return "ok";
    }
}
