package com.navod.web.nmshop.controller.admin;


import com.navod.web.nmshop.annotation.ApiSecure;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;
//@ApiSecure
@Path("/admin/dashboard")
public class DashBoardController {
    @GET
    public Viewable index(){
        System.out.println("This is dashboard");
        return new Viewable("/backend/dashboard");
    }
}
