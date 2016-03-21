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
import com.beans.lab;
import com.services.Impl.LabImpl;

@Path("/lab")
public class LabService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addLab(lab b) {
		LabImpl instance = LabImpl.getInstance();

		Response resp = instance.addLab(b);

		return resp;
	}

	@GET
	@Path("/get/{labId}")
	@Produces(MediaType.APPLICATION_XML)
	public lab getLab(@PathParam("labId") String labId) {
		lab lr = new lab();
		System.out.println("Fresh Get Lab");
		System.out.println("Lab Id =" + labId);

		if (labId.equalsIgnoreCase("10")) {
			lr.setLabId(labId);
			lr.setLabName("PATIALA LAB");
		}
		if (labId.equalsIgnoreCase("20")) {
			lr.setLabId(labId);
			lr.setLabName("CHANDIGARH LAB");
		}
		System.out.println("Get Lab  =>" + lr);

		return lr;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<lab> getLabList() {
		ArrayList<lab> labList = new ArrayList<lab>();
		lab lr = new lab();
		System.out.println("Get Entire Lab List");
		lr.setLabId("10");
		lr.setLabName("PATIALA LAB");
		labList.add(lr);
		lab lr2 = new lab();
		lr2.setLabId("20");
		lr2.setLabName("CHANDIGARH LAB");
		labList.add(lr2);

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateLab(lab b) {

		Response resp = new Response();

		System.out.println("Update Lab => " + b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@DELETE
	@Path("/delete/{labId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteLab(@PathParam("labId") String labId) {
		Response resp = new Response();
		System.out.println("Delete Lab");
		System.out.println("Lab Id =" + labId);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
}
