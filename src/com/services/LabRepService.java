package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.LabRep;
import com.beans.Response;
import com.services.Impl.LabRepImpl;

@Path("/labRep")
public class LabRepService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addLab(LabRep b) {
		LabRepImpl instance = LabRepImpl.getInstance();
		Response resp = instance.addLab(b);

		return resp;
	}

	@GET
	@Path("/get/{labRepId}")
	@Produces(MediaType.APPLICATION_XML)
	public LabRep getLab(@PathParam("labRepId") Long labRepId) {

		LabRepImpl instance = LabRepImpl.getInstance();
		LabRep lr = instance.getLab(labRepId);

		return lr;

	}

	@GET
	@Path("/getList/labBranchCode")
	@Produces(MediaType.APPLICATION_XML)
	public List<LabRep> getLabRepList(@PathParam("labBranchCode") Long labBranchCode) {

		LabRepImpl instance = LabRepImpl.getInstance();
		List<LabRep> labList = instance.getLabRepList(labBranchCode);

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateLab(LabRep b) {

		LabRepImpl instance = LabRepImpl.getInstance();
		Response resp = instance.updateLab(b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete/{labBranchCode}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteLab(@PathParam("labBranchCode") Long labBranchCode) {

		LabRepImpl instance = LabRepImpl.getInstance();
		Response resp = instance.deleteLabRep(labBranchCode);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
	@POST
	@Path("/activateLabRep/{labBranchCode}")
	@Produces(MediaType.APPLICATION_XML)
	public Response activateLabRep(@PathParam("labBranchCode") Long labBranchCode) {

		LabRepImpl instance = LabRepImpl.getInstance();
		Response resp = instance.activateLabRep(labBranchCode);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
}
