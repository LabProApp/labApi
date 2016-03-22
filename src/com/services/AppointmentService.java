package com.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Appointment;
import com.beans.Response;
import com.beans.LabBranch;
import com.services.Impl.AppointmentImpl;

@Path("/appointment")
public class AppointmentService {

	@POST
	@Path("/bookAppointment")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response BookAppointment(@PathParam("appmnt") Appointment appmnt) {
		Response resp = new Response();

		System.out.println("Book Appointment " + appmnt);
		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		appmntImpl.BookAppointment(appmnt);
		return resp;
	}

	@GET
	@Path("/cancelAppointment/{appntId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response cancelAppointment(@PathParam("appntId") String appntId) {

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		Response resp = appmntImpl.cancelAppointment(appntId);
		return resp;

	}

	@GET
	@Path("/getAppointListbyLab")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<LabBranch> getAppointListbyLab(@PathParam("LabId") String LabId) {
		ArrayList<LabBranch> AppointListbyLab = new ArrayList<LabBranch>();

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		AppointListbyLab = appmntImpl.getAppointListbyLab(LabId);
		return AppointListbyLab;

	}

	@GET
	@Path("/getAppointListbyCustomer")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<LabBranch> getAppointListbyCustomer(
			@PathParam("CustomerId") String CustomerId) {
		ArrayList<LabBranch> AppointListbyCustomer = new ArrayList<LabBranch>();

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		AppointListbyCustomer = appmntImpl.getAppointListbyCustomer(CustomerId);
		return AppointListbyCustomer;

	}

	@PUT
	@Path("/updateAppointment")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateAppointment(@PathParam("appmnt") Appointment appmnt) {

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		Response resp = appmntImpl.updateAppointment(appmnt);
		return resp;
	}

}
