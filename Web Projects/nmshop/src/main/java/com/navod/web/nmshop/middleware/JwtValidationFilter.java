package com.navod.web.nmshop.middleware;

import com.navod.web.nmshop.annotation.ApiSecure;
import com.navod.web.nmshop.entity.User;
import com.navod.web.nmshop.service.UserService;
import com.navod.web.nmshop.util.JwtTokenUtil;
import com.navod.web.nmshop.util.JwtTokenUtilAdmin;
import io.fusionauth.jwt.JWTExpiredException;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;


import java.io.IOException;
import java.util.Optional;

@Provider
@ApiSecure
@Priority(1)
public class JwtValidationFilter implements ContainerRequestFilter {

    @Inject
    private JwtTokenUtil tokenUtil;

    @Inject
    private JwtTokenUtilAdmin tokenUtilAdmin;

    @Context
    private HttpServletRequest request;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("JwtValidationFilter...");
        UserService userService = new UserService();
        String path = requestContext.getUriInfo().getPath();
        System.out.println(path);
        if (requestContext.getHeaders().getFirst("Authorization") == null){
            System.out.println("First header authorization");
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }else {
            System.out.println("in else");
            HttpSession session = request.getSession();
            String userid = session.getAttribute("user").toString();
            System.out.println(userid);
            User user = userService.getById(Long.valueOf(userid));
            String token = requestContext.getHeaders().getFirst("Authorization").split(" ")[1];
            System.out.println(token);
            try{
                System.out.println("tryCatch");
                Optional<User> byEmail;
//                if(byEmail.isPresent()){
                    System.out.println("Email is present");
                    if(user.getUserType().toString().equals("ADMIN")){
                        byEmail = userService.getByEmail(tokenUtilAdmin.getUsernameFromToken(token));
                        if (!tokenUtilAdmin.validateToken(token, user)){
                            System.out.println("Admin Validation");
                            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                        }else {
                            System.out.println("Admin authorized");
                            session = request.getSession(false);
                            session.setAttribute("user", user.getId());
                        }
                    }else{
                        byEmail = userService.getByEmail(tokenUtil.getUsernameFromToken(token));
                        if (!tokenUtil.validateToken(token, user)){
                            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                        }else {
                            session = request.getSession(false);
                            session.setAttribute("user", user.getId());
                        }
                    }
//                }
//                if(user.getUserType().toString().equals("ADMIN")){
//                    byEmail = userService.getByEmail(tokenUtilAdmin.getUsernameFromToken(token));
//                }else{
//                    byEmail = userService.getByEmail(tokenUtil.getUsernameFromToken(token));
//                }
//                if (byEmail.isPresent()){
////                    User user = byEmail.get();
//                    if(user.getUserType().toString().equals("ADMIN")){
//                        if (!tokenUtilAdmin.validateToken(token, user)){
//                            System.out.println("Admin Validation");
//                            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
//                        }else {
//                            System.out.println("Admin authorized");
//                            HttpSession session = request.getSession(false);
//                            session.setAttribute("user", user.getId());
//                        }
//                    }else{
//                        if (!tokenUtil.validateToken(token, user)){
//                            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
//                        }else {
//                            HttpSession session = request.getSession(false);
//                            session.setAttribute("user", user.getId());
//                        }
//                    }
//                }
            }catch (JWTExpiredException | NullPointerException ex){
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Token Expired....").build());
            } catch (Exception ex){
                ex.printStackTrace();
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        }

    }
}
