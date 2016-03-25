package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Appointment;
import com.beans.Response;
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
	public Response cancelAppointment(@PathParam("appntId") Long appntId) {

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		Response resp = appmntImpl.cancelAppointment(appntId);
		return resp;

	}

	@GET
	@Path("/getAppointListbyLabOffice")
	@Produces(MediaType.APPLICATION_XML)
	public List<Appointment> getAppointListbyLabOffice(@PathParam("LabId") Long LabId) {
		List<Appointment> AppointListbyLab = new ArrayList<Appointment>();

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		AppointListbyLab = appmntImpl.getAppointListbyLab(LabId);
		return AppointListbyLab;

	}
	@GET
	@Path("/getAppointListbyLabBranch")
	@Produces(MediaType.APPLICATION_XML)
	public List<Appointment> getAppointListbyLabBranch(@PathParam("LabId") Long LabId) {
		List<Appointment> AppointListbyLab = new ArrayList<Appointment>();

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		AppointListbyLab = appmntImpl.getAppointListbyLab(LabId);
		return AppointListbyLab;

	}

	@GET
	@Path("/getAppointListbyLabRep")
	@Produces(MediaType.APPLICATION_XML)
	public List<Appointment> getAppointListbyLabRep(@PathParam("LabId") Long LabId) {
		List<Appointment> AppointListbyLab = new ArrayList<Appointment>();

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		AppointListbyLab = appmntImpl.getAppointListbyLab(LabId);
		return AppointListbyLab;

	}

	@GET
	@Path("/getAppointListbyCustomer")
	@Produces(MediaType.APPLICATION_XML)
	public List<Appointment> getAppointListbyCustomer(
			@PathParam("CustomerId") Long CustomerId) {
		List<Appointment> AppointListbyCustomer = new ArrayList<Appointment>();

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		AppointListbyCustomer = appmntImpl.getAppointListbyCustomer(CustomerId);
		return AppointListbyCustomer;

	}
	@GET
	@Path("/getAppointListbyDoctor")
	@Produces(MediaType.APPLICATION_XML)
	public List<Appointment> getAppointListbyDoctor(
			@PathParam("DoctorId") Long DoctorId) {
		List<Appointment> AppointListbyCustomer = new ArrayList<Appointment>();

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		AppointListbyCustomer = appmntImpl.getAppointListbyDoctor(DoctorId);
		return AppointListbyCustomer;

	}

	@POST
	@Path("/updateAppointment")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateAppointment(@PathParam("appmnt") Appointment appmnt) {

		AppointmentImpl appmntImpl = AppointmentImpl.getInstance();
		Response resp = appmntImpl.updateAppointment(appmnt);
		return resp;
	}

}
