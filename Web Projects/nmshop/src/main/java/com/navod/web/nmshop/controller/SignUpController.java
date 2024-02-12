package com.navod.web.nmshop.controller;

import com.navod.web.nmshop.dto.RegisterDTO;
import com.navod.web.nmshop.entity.User;
import com.navod.web.nmshop.mail.VerificationMail;
import com.navod.web.nmshop.provider.MailServiceProvider;
import com.navod.web.nmshop.service.UserService;
import com.navod.web.nmshop.util.Encryption;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;

import java.util.Optional;
import java.util.UUID;

@Path("/signup")
public class SignUpController {
    @GET
    public Viewable index(){
        return new Viewable("/frontend/auth/sign-up");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signUp(RegisterDTO registerDTO){
        UserService userService = new UserService();
        Optional<User> byEmail = userService.getByEmail(registerDTO.getEmail());
        if(byEmail.isPresent()){
            return Response.status(Response.Status.BAD_REQUEST).entity("Email already exists").build();
        }else{
            User user = userService.registerUser(registerDTO);

            VerificationMail verificationMail = new VerificationMail(user.getEmail(), user.getVerification_code());
            MailServiceProvider.getInstance().sendMail(verificationMail);

            return Response.ok().entity("Register Success").build();
        }
    }
}
