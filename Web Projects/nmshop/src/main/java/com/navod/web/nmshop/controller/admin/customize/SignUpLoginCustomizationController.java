package com.navod.web.nmshop.controller.admin.customize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.navod.web.nmshop.dto.signUpImageDTO;
import com.navod.web.nmshop.entity.AppSetting;
import com.navod.web.nmshop.entity.SignUpImage;
import com.navod.web.nmshop.service.AppSettingService;
import com.navod.web.nmshop.service.FileUploadService;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.mvc.Viewable;

import java.io.InputStream;

@Path("/admin/customize/signupandLogin")
public class SignUpLoginCustomizationController {
    @Context
    ServletContext context;

    @GET
    public Viewable index(){
        return new Viewable("/backend/customize/signUp-and-login-customization");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processTitle(signUpImageDTO titleDTO){
        AppSettingService appSettingService = new AppSettingService();
        SignUpImage signUpImage = new SignUpImage();
        signUpImage.setTitle(titleDTO.getTitle());

        appSettingService.saveSignUpImage(signUpImage);
        ObjectNode jsonNodes = new ObjectMapper().createObjectNode();
        jsonNodes.put("pid",signUpImage.getId());

        return Response.ok().entity(jsonNodes).build();
    }

    @Path("/getTitle")
    @GET
    public Response getTitle(){

        return Response.ok().build();
    }

    @POST
    @Path("/upload-image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response action(@FormDataParam("file")InputStream inputStream, @FormDataParam("file")FormDataContentDisposition fileMetaData){
        FileUploadService uploadService = new FileUploadService(context);
        FileUploadService.FileItem fileItem = uploadService.upload("sign/s1", inputStream, fileMetaData);
        System.out.println(fileItem.getFileName());
        System.out.println(fileItem.getFileNameOriginal());
        return Response.ok().entity(fileItem).build();
    }


}
