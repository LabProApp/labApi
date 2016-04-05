package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.LabBranch;
import com.beans.Response;
import com.dto.LabBranchDto;
import com.services.Impl.LabBranchImpl;

@Path("/labbranch")
public class LabBranchService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addLab(LabBranch b) {
		LabBranchImpl instance = LabBranchImpl.getInstance();
		Response resp = instance.addLab(b);

		return resp;
	}

	@GET
	@Path("/get/{labbranchCode}")
	@Produces(MediaType.APPLICATION_XML)
	public LabBranch getLab(@PathParam("labbranchCode") Long labbranchCode) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		LabBranch lr = instance.getLab(labbranchCode);

		return lr;

	}

	@GET
	@Path("/getLabList/{OfficeId}")
	@Produces(MediaType.APPLICATION_XML)
	public List<LabBranchDto> getLabList(@PathParam("OfficeId") Long OfficeId) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		List<LabBranchDto> labList = instance.getLabList(OfficeId);

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateLabBranch(LabBranch b) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		Response resp = instance.updateLabBranch(b);

		
		return resp;
	}

	@POST
	@Path("/delete/{labBranchCode}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteLab(@PathParam("labBranchCode") Long labBranchCode) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		Response resp = instance.deleteLabBranch(labBranchCode);

	
		return resp;
	}
	@Path("/activateLabBranch/{labBranchCode}")
	@Produces(MediaType.APPLICATION_XML)
	public Response activateLabBranch(@PathParam("labBranchCode") Long labBranchCode) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		Response resp = instance.activateLabBranch(labBranchCode);

	
		return resp;
	}
}
