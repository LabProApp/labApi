package com.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.LabBranch;
import com.services.Impl.LabImpl;

@Path("/lab")
public class LabService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addLab(LabBranch b) {
		LabImpl instance = LabImpl.getInstance();
		Response resp = instance.addLab(b);

		return resp;
	}

	@GET
	@Path("/get/{labId}")
	@Produces(MediaType.APPLICATION_XML)
	public LabBranch getLab(@PathParam("labId") String labId) {

		LabImpl instance = LabImpl.getInstance();
		LabBranch lr = instance.getLab(labId);

		return lr;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<LabBranch> getLabList() {

		LabImpl instance = LabImpl.getInstance();
		ArrayList<LabBranch> labList = instance.getLabList();

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateLab(LabBranch b) {

		LabImpl instance = LabImpl.getInstance();
		Response resp = instance.updateLab(b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@DELETE
	@Path("/delete/{labId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteLab(@PathParam("labId") String labId) {

		LabImpl instance = LabImpl.getInstance();
		Response resp = instance.deleteLab(labId);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
}
