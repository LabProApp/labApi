package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.beans.LabOffice;
import com.beans.Response;
import com.services.Impl.LabOfficeImpl;

@Path("/laboffice")
public class LabOfficeService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addLab(LabOffice b) {
		LabOfficeImpl instance = LabOfficeImpl.getInstance();
		Response resp = instance.addLabOffice(b);

		return resp;
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public LabOffice getLabOffice(@QueryParam("labOfficeId") Long labOfficeId) {

		LabOfficeImpl instance = LabOfficeImpl.getInstance();
		LabOffice lr = instance.getLabOffice(labOfficeId);

		return lr;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_XML)
	public List<LabOffice> getLabOfficeList() {

		LabOfficeImpl instance = LabOfficeImpl.getInstance();
		List<LabOffice> labList = instance.getLabOfficeList();

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateLabOffice(LabOffice b) {

		LabOfficeImpl instance = LabOfficeImpl.getInstance();
		Response resp = instance.updateLabOffice(b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteLabOffice(@QueryParam("labOfficeId") Long labOfficeId) {

		LabOfficeImpl instance = LabOfficeImpl.getInstance();
		Response resp = instance.deleteLabOffice(labOfficeId);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
	@POST
	@Path("/activateLabOffice")
	@Produces(MediaType.APPLICATION_XML)
	public Response activateLabOffice(@QueryParam("labOfficeId") Long labOfficeId) {

		LabOfficeImpl instance = LabOfficeImpl.getInstance();
		Response resp = instance.activateLabOffice(labOfficeId);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
}
