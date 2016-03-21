package com.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Appointment;
import com.beans.Response;
import com.services.Impl.PerformTestImpl;

@Path("/performtest")
public class PerformTestService {
	@GET
	@Path("/getReports")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response getReports(Appointment appmnt) {

		PerformTestImpl instance = PerformTestImpl.getInstance();

		Response resp = instance.getReports(appmnt);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/updateStatus")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateStatus(Appointment appmnt) {
		PerformTestImpl instance = PerformTestImpl.getInstance();

		Response resp = instance.updateStatus(appmnt);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/uploadReports/{appntId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response uploadReports(@PathParam("appntId") String appntId) {

		PerformTestImpl instance = PerformTestImpl.getInstance();

		Response resp = instance.uploadReports(appntId);

		// TODO
		// Update AppmntStatus = REPORTS_UPLOADED
		// Upload Reports in BLOB

		return resp;

	}

}
