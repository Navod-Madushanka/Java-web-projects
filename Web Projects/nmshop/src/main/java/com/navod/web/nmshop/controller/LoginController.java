package com.navod.web.nmshop.controller;

import com.navod.web.nmshop.dto.AuthDTO;
import com.navod.web.nmshop.dto.AuthResponseDTO;
import com.navod.web.nmshop.entity.User;
import com.navod.web.nmshop.service.UserService;
import com.navod.web.nmshop.util.Encryption;
import com.navod.web.nmshop.util.JwtTokenUtil;
import com.navod.web.nmshop.util.JwtTokenUtilAdmin;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.mvc.Viewable;

import java.util.Date;
import java.util.Optional;

@Path("/login")
public class LoginController {
    @Inject
    JwtTokenUtil tokenUtil;

    @Inject
    JwtTokenUtilAdmin tokenUtilAdmin;

    @GET
    public Viewable index(){
        return new Viewable("/frontend/auth/sign-in");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logIn(AuthDTO authDTO, @Context HttpServletRequest request){
        UserService userService = new UserService();
        Optional<User> byEmail = userService.getByEmail(authDTO.getEmail());

        if(byEmail.isPresent()){
            User user = byEmail.get();
            if(user.getPassword().equals(Encryption.encrypt(authDTO.getPassword()))){
                if(user.isActive() && !user.getEmail_verified_at().isEmpty()){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user.getId());

                    AuthResponseDTO authResponseDTO;
                    String accessToken;
                    String refreshToken;
                    Date expireDate;
                    String userType = "";

                    if(user.getUserType().toString().equals("ADMIN")){
                        userType = "admin";
                        accessToken = tokenUtilAdmin.generateAccessToken(user);
                        refreshToken = tokenUtilAdmin.generateRefreshToken(user);
                        expireDate = tokenUtilAdmin.getExpireDateFromToken(accessToken);

                    }else{
                        userType = "user";
                        accessToken = tokenUtil.generateAccessToken(user);
                        refreshToken = tokenUtil.generateRefreshToken(user);
                        expireDate = tokenUtil.getExpireDateFromToken(accessToken);
                    }

                    authResponseDTO = new AuthResponseDTO(userType,accessToken, refreshToken, String.valueOf(expireDate.getTime()));
                    return Response.ok().entity(authResponseDTO).build();
                }else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user.getId());
                    return Response.status(Response.Status.FORBIDDEN).build();
                }
            }else{
                return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Email or Password").build();
            }
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Email or Password").build();
        }
    }
    @POST
    @Path("login/refresh-token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response refreshToken(@FormParam("token") String refreshToken, @FormParam("userType") String userType){
        Optional<User> optionalUser;
        UserService userService = new UserService();
        if(userType.equals("admin")){
            optionalUser = userService.getByEmail(tokenUtilAdmin.getUsernameFromToken(refreshToken));
            if(optionalUser.isEmpty() || !tokenUtilAdmin.validateToken(refreshToken, optionalUser.get())){
                return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Refresh Token").build();
            }
        }else{
            optionalUser = userService.getByEmail(tokenUtil.getUsernameFromToken(refreshToken));
            if(optionalUser.isEmpty() || !tokenUtil.validateToken(refreshToken, optionalUser.get())){
                return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Refresh Token").build();
            }
        }
            User user = optionalUser.get();
            String accessToken;
            Date expireIn = null;
            userType = "";

            if(user.getUserType().toString().equals("ADMIN")){
                userType = "admin";
                accessToken = tokenUtilAdmin.generateAccessToken(user);
                expireIn = tokenUtilAdmin.getExpireDateFromToken(accessToken);
            }else{
                accessToken = tokenUtil.generateAccessToken(user);
                expireIn = tokenUtil.getExpireDateFromToken(accessToken);
            }

            AuthResponseDTO authResponseDTO = new AuthResponseDTO(userType,accessToken, refreshToken, String.valueOf(expireIn.getTime()));

            return Response.ok().entity(authResponseDTO).build();
    }
}
