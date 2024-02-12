package com.navod.jersey.app.controller;

import com.navod.jersey.app.dto.AuthResponseDTO;
import com.navod.jersey.app.model.UserDetails;
import com.navod.jersey.app.service.UserService;
import com.navod.jersey.app.util.JwtTokenUnit;
import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Date;

@Path("/")
public class AuthController {

    @Inject
    private JwtTokenUnit tokenUnit;
    @Inject
    private UserService userService;
    @Path("/auth")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response auth(@FormParam("email") String email, @FormParam("password") String password){
        if(email.equals("abc@gmail.com")&&password.equals("1234")){
            UserDetails ud = userService.getUserByEmail(email);
            String accessToken = tokenUnit.generateAccessToken(ud);
            String refreshToken = tokenUnit.generateRefreshToken(ud);
            Date expireDate = tokenUnit.getExpireDateFromToken(accessToken);

            AuthResponseDTO dto = new AuthResponseDTO();
            dto.setAccessToken(accessToken);
            dto.setRefreshToken(refreshToken);
            dto.setExpireIn(expireDate.toString());

            return Response.ok().entity(dto).build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid email or password").build();
        }
    }

    @Path("/refresh-token")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response refreshToken(@FormParam("refreshToken") String refreshToken){
        UserDetails userDetails = userService.getUserByEmail(tokenUnit.getUsernameFromToken(refreshToken));

        if(tokenUnit.validateToken(refreshToken, userDetails)){
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid refresh token").build();
        }else{
            String accessToken = tokenUnit.generateAccessToken(userDetails);
            Date expireDate = tokenUnit.getExpireDateFromToken(accessToken);

            AuthResponseDTO dto = new AuthResponseDTO();
            dto.setAccessToken(accessToken);
            dto.setRefreshToken(refreshToken);
            dto.setExpireIn(expireDate.toString());

            return Response.ok().entity(dto).build();
        }
    }

}
