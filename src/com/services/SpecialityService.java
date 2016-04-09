package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.Speciality;
import com.services.Impl.SpecialityImpl;

@Path("/speciality")
public class SpecialityService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.APPLICATION_XML)
	public Response add(Speciality spec) {

		System.out.println("Add Speciality =>" + spec);
		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		Response resp = specsImpl.add(spec);
		return resp;
	}

	@GET
	@Path("/get/{specsId}")
	@Produces(MediaType.APPLICATION_XML)
	public Speciality get(@PathParam("specsId") Long specsId) {
		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		Speciality spec = specsImpl.get(specsId);
		return spec;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_XML)
	public List<Speciality> getspecsList() {
		List<Speciality> testList;
		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		testList = specsImpl.getspecList();
		return testList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updatespecs(Speciality spec) {

		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		Response resp = specsImpl.updatespec(spec);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete/{specsId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deletespecs(@PathParam("specsId") Long specsId) {

		System.out.println("Delete specs");
		SpecialityImpl specsImpl = SpecialityImpl.getInstance();
		Response resp = specsImpl.deletespec(specsId);

		return resp;

	}
}
