package com.navod.web.nmshop.controller.admin;

import com.navod.web.nmshop.annotation.ApiSecure;
import com.navod.web.nmshop.service.FileUploadService;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.mvc.Viewable;

import java.io.InputStream;
@Path("/admin/product")
public class ProductController {
    @Context
    ServletContext context;

    @GET
    public Viewable index(){
        return new Viewable("/backend/product/view");
    }

    @GET
    @Path("/add")
    public Viewable add() {
        return new Viewable("/backend/product/add");
    }

    @Path("/upload-image")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response action(@FormDataParam("file")InputStream inputStream, @FormDataParam("file")FormDataContentDisposition fileMetaData){
        FileUploadService uploadService = new FileUploadService(context);
        FileUploadService.FileItem fileItem = uploadService.upload("slider/s1",inputStream, fileMetaData);
        System.out.println(fileItem.getFileName());
        return Response.ok().entity(fileItem).build();
    }

}
