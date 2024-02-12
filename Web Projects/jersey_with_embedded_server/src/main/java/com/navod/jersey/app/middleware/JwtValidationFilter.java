package com.navod.jersey.app.middleware;

import com.navod.jersey.app.model.UserDetails;
import com.navod.jersey.app.service.UserService;
import com.navod.jersey.app.util.JwtTokenUnit;
import io.fusionauth.jwt.JWTExpiredException;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.apache.jasper.compiler.JspUtil;
import org.glassfish.jersey.internal.util.Property;

import java.io.IOException;
@Provider
@Priority(1)
@PreMatching
public class JwtValidationFilter implements ContainerRequestFilter {
    @Inject
    private JwtTokenUnit tokenUnit;
    @Inject
    private UserService userService;
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String path = requestContext.getUriInfo().getPath();
        if(path.equals("auth") || path.equals("refresh-token")){
            return;
        }

        if(requestContext.getHeaders().getFirst("Authorization") == null){
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }else{
            String token = requestContext.getHeaders().getFirst("Authorization").split(" ")[1];
            try {
                UserDetails userDetails = userService.getUserByEmail(tokenUnit.getUsernameFromToken(token));
                if (!tokenUnit.validateToken(token, userDetails)) {
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                }
            }catch(JWTExpiredException | NullPointerException ex){
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Token Expire").build());
            }catch (Exception e){
                e.printStackTrace();
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        }
    }
}
