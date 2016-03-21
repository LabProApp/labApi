package com.services.Impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Appointment;
import com.beans.Response;

@Path("/performtest")
public class PerformImpl {
	@GET
	@Path("/getReports")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response getReports(Appointment appmnt) {
		Response resp = new Response();
		
		
		
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/updateStatus")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateStatus(Appointment appmnt) {
		Response resp = new Response();
		
		//TODO 
		//Update AppmntStatus = TEST_EXECUTED/SAMPLE_COLLECTED/
		
		resp.setSTATUS("SUCCESS");
		return resp;
	}
	@POST
	@Path("/uploadReports/{appntId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response uploadReports(@PathParam("appntId") String appntId,@PathParam("Reports") Object Reports) {

		Response resp = new Response();
		//TODO 
		//Update AppmntStatus = REPORTS_UPLOADED
		//Upload Reports in BLOB 
		
		return resp;

	}

	
	
}
