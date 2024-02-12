package com.navod.web.nmshop.controller.api;

import com.navod.web.nmshop.annotation.ApiSecure;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@ApiSecure
@Path("/api/v1/category")
public class categoryController {
    @GET
    public Response get(){
        return Response.ok().entity("Test").build();
    }
}

