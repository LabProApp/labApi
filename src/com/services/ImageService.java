package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.beans.Images;
import com.beans.Response;
import com.services.Impl.ImagesImpl;

@Path("/image")
public class ImageService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Images image) {

		System.out.println("Add Images =>" + image);
		ImagesImpl imageImpl = ImagesImpl.getInstance();
		Response resp = imageImpl.add(image);
		return resp;
	}

	@GET
	@Path("/download")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Images download(Images image) {
		ImagesImpl imageImpl = ImagesImpl.getInstance();
		Images imagedwnld = imageImpl.download(image);
		return imagedwnld;

	}
	@GET
	@Path("/getImageList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Images> getImageList(@QueryParam("entityId") Long entityId,@QueryParam("entityTyp") String entityTyp) {
		ImagesImpl imageImpl = ImagesImpl.getInstance();
		List<Images> imagesList = imageImpl.getImageList(entityId,entityTyp);
		return imagesList;

	}
	/*@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateimage(Images image) {

		ImagesImpl imageImpl = ImagesImpl.getInstance();
		Response resp = imageImpl.updateimage(image);
		resp.setSTATUS("SUCCESS");
		return resp;
	}*/

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteimage(Images image) {

		System.out.println("Delete image");
		ImagesImpl imageImpl = ImagesImpl.getInstance();
		Response resp = imageImpl.deleteimage(image);

		return resp;

	}

}
