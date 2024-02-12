package com.navod.mvc_pactice.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HomeController {
    @GET
    public String get(){
        return "Home";
    }
}
