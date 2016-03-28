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

import com.beans.Response;
import com.beans.Schedule;
import com.services.Impl.ScheduleImpl;

@Path("/Schedule")
public class ScheduleService {

	@POST
	@Path("/addSchedule")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addSchedule(@PathParam("schdule") Schedule schdule) {
		Response resp = new Response();

		System.out.println("Book Schedule " + schdule);
		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		schduleImpl.addSchedule(schdule);
		return resp;
	}

	@GET
	@Path("/deleteSchedule/{schduleId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteSchedule(@PathParam("schduleId") Long schduleId) {

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		Response resp = schduleImpl.deleteSchedule(schduleId);
		return resp;

	}

	@GET
	@Path("/getSchedulebyScheduleId")
	@Produces(MediaType.APPLICATION_XML)
	public Schedule getSchedulebyScheduleId(
			@PathParam("ScheduleId") Long ScheduleId) {
		Schedule schedule;

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		schedule = schduleImpl.getSchedulebyScheduleId(ScheduleId);
		return schedule;

	}

	@GET
	@Path("/getScheduleListbyLabOffice")
	@Produces(MediaType.APPLICATION_XML)
	public List<Schedule> getScheduleListbyLabOffice(
			@PathParam("LabOfficeId") Long LabOfficeId) {
		List<Schedule> scheduleListbyLabOffice = new ArrayList<Schedule>();

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		scheduleListbyLabOffice = schduleImpl
				.getScheduleListbyLabOffice(LabOfficeId);
		return scheduleListbyLabOffice;

	}

	@GET
	@Path("/getScheduleListbyLabBranch")
	@Produces(MediaType.APPLICATION_XML)
	public List<Schedule> getScheduleListbyLabBranch(
			@PathParam("LabBranchCd") Long LabBranchCd) {
		List<Schedule> scheduleListbyLabBranch = new ArrayList<Schedule>();

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		scheduleListbyLabBranch = schduleImpl
				.getScheduleListbyLabBranch(LabBranchCd);
		return scheduleListbyLabBranch;

	}

	@GET
	@Path("/getScheduleListbyLabRep")
	@Produces(MediaType.APPLICATION_XML)
	public List<Schedule> getScheduleListbyLabRep(
			@PathParam("LabRepId") Long LabRepId) {
		List<Schedule> scheduleListbyLabRep = new ArrayList<Schedule>();

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		scheduleListbyLabRep = schduleImpl.getScheduleListbyLabRep(LabRepId);
		return scheduleListbyLabRep;

	}

	@GET
	@Path("/getScheduleListbyDoctor")
	@Produces(MediaType.APPLICATION_XML)
	public List<Schedule> getScheduleListbyDoctor(
			@PathParam("DoctorId") Long DoctorId) {
		List<Schedule> scheduleListbyDoctor = new ArrayList<Schedule>();

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		scheduleListbyDoctor = schduleImpl.getScheduleListbyDoctor(DoctorId);
		return scheduleListbyDoctor;

	}
	@GET
	@Path("/getScheduleListbyHospital")
	@Produces(MediaType.APPLICATION_XML)
	public List<Schedule> getScheduleListbyHospital(
			@PathParam("HospitalId") Long HospitalId) {
		List<Schedule> scheduleListbyHospital = new ArrayList<Schedule>();

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		scheduleListbyHospital = schduleImpl.getScheduleListbyHospital(HospitalId);
		return scheduleListbyHospital;

	}
	

	@POST
	@Path("/updateSchedule")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateSchedule(@PathParam("schdule") Schedule schdule) {

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		Response resp = schduleImpl.updateSchedule(schdule);
		return resp;
	}

}
