package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.Speciality;
import com.services.Impl.SpecialityImpl;

@Path("/speciality")
public class SpecialityService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Speciality spec) {

		System.out.println("Add Speciality =>" + spec);
		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		Response resp = specsImpl.add(spec);
		return resp;
	}
	
	@GET
	@Path("/getspecsListbyTag")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Speciality> getspecsListbyTag(
			@QueryParam("searchString") String searchString) {
		List<Speciality> testList;
		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		testList = specsImpl.getspecsListbyTag(searchString);
		return testList;

	}
	

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Speciality> getspecsList() {
		List<Speciality> testList;
		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		testList = specsImpl.getspecList();
		return testList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatespecs(Speciality spec) {

		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		Response resp = specsImpl.updatespec(spec);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletespecs(@QueryParam("specsId") Long specsId) {

		System.out.println("Delete specs");
		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		Response resp = specsImpl.deletespec(specsId);

		return resp;

	}
}
