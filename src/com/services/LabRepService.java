package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.beans.LabRep;
import com.beans.Response;
import com.services.Impl.LabRepImpl;

@Path("/labRep")
public class LabRepService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addLab(LabRep b) {
		LabRepImpl instance = LabRepImpl.getInstance();
		Response resp = instance.addLab(b);

		return resp;
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public LabRep get(@QueryParam("labRepId") Long labRepId) {

		LabRepImpl instance = LabRepImpl.getInstance();
		LabRep lr = instance.get(labRepId);

		return lr;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LabRep> getList(@QueryParam("labBranchCode") Long labBranchCode) {

		LabRepImpl instance = LabRepImpl.getInstance();
		List<LabRep> labList = instance.getList(labBranchCode);

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(LabRep b) {

		LabRepImpl instance = LabRepImpl.getInstance();
		Response resp = instance.updateLab(b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("labBranchCode") Long labBranchCode) {

		LabRepImpl instance = LabRepImpl.getInstance();
		Response resp = instance.delete(labBranchCode);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
	@POST
	@Path("/activateLabRep")
	@Produces(MediaType.APPLICATION_JSON)
	public Response activateLabRep(@QueryParam("labBranchCode") Long labBranchCode) {

		LabRepImpl instance = LabRepImpl.getInstance();
		Response resp = instance.activateLabRep(labBranchCode);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
}
