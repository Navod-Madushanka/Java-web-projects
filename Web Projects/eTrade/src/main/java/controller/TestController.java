package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test")
public class TestController {
    @GET
    public void test(){
        System.out.println("testController");
    }
}
