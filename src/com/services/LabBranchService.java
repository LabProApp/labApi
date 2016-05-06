package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public LabBranch getLab(@QueryParam("labbranchCode") Long labbranchCode) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		LabBranch lr = instance.getLab(labbranchCode);

		return lr;

	}

	@GET
	@Path("/getLabList")
	@Produces(MediaType.APPLICATION_XML)
	public List<LabBranchDto> getLabList(@QueryParam("OfficeId") Long OfficeId) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		List<LabBranchDto> labList = instance.getLabList(OfficeId);

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	@GET
	@Path("/getLabBranchByCity")
	@Produces(MediaType.APPLICATION_XML)
	public List<LabBranchDto> getLabBranchByCity(
			@QueryParam("city") String city, @QueryParam("state") String state) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		List<LabBranchDto> labList = instance.getLabBranchByCity(city, state);
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
	@Path("/delete")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteLab(@QueryParam("labBranchCode") Long labBranchCode) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		Response resp = instance.deleteLabBranch(labBranchCode);

		return resp;
	}

	@Path("/activateLabBranch")
	@Produces(MediaType.APPLICATION_XML)
	public Response activateLabBranch(
			@QueryParam("labBranchCode") Long labBranchCode) {

		LabBranchImpl instance = LabBranchImpl.getInstance();
		Response resp = instance.activateLabBranch(labBranchCode);

		return resp;
	}
}
