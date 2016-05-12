package com.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.S3Image;
import com.services.Impl.CommonImpl;

@Path("/common")
public class CommonService {
	@POST
	@Path("/upload_s3")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response upload_s3(S3Image img) {
 
		System.out.println("Add Images =>" + img);
		CommonImpl commonImpl = CommonImpl.getInstance();
		Response resp = commonImpl.upload_s3(img);
		return resp;
	}
	@GET
	@Path("/download_s3")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public S3Image download_s3(@QueryParam("img_name") String img_name) {
 
		System.out.println("Download Image =>" + img_name);
		CommonImpl commonImpl = CommonImpl.getInstance();
		S3Image img1 = commonImpl.download_s3(img_name);
		return img1;
	}

}
