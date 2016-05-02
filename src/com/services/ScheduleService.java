package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.Schedule;
import com.services.Impl.ScheduleImpl;

@Path("/schedule")
public class ScheduleService {

	@POST
	@Path("/addSchedule")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addSchedule(Schedule schdule) {
		Response resp = new Response();

		System.out.println("Book Schedule " + schdule);
		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		resp=schduleImpl.addSchedule(schdule);
		return resp;
	}

	@POST
	@Path("/deleteSchedule")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteSchedule(@QueryParam("schduleId") Long schduleId) {

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		Response resp = schduleImpl.deleteSchedule(schduleId);
		return resp;

	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public Schedule getSchedulebyScheduleId(
			@QueryParam("scheduleId") Long scheduleId) {
		Schedule schedule;

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		schedule = schduleImpl.getSchedulebyScheduleId(scheduleId);
		return schedule;

	}

	

	@GET
	@Path("/getScheduleListbyLabBranch")
	@Produces(MediaType.APPLICATION_XML)
	public List<Schedule> getScheduleListbyLabBranch(
			@QueryParam("LabBranchCd") Long LabBranchCd) {
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
			
			@QueryParam("LabRepId") Long LabRepId) {
		List<Schedule> scheduleListbyLabRep = new ArrayList<Schedule>();

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		scheduleListbyLabRep = schduleImpl.getScheduleListbyLabRep(LabRepId);
		return scheduleListbyLabRep;

	}

	@GET
	@Path("/getScheduleListbyDoctor")
	@Produces(MediaType.APPLICATION_XML)
	public List<Schedule> getScheduleListbyDoctor(
			@QueryParam("DoctorId") Long DoctorId) {
		List<Schedule> scheduleListbyDoctor = new ArrayList<Schedule>();

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		scheduleListbyDoctor = schduleImpl.getScheduleListbyDoctor(DoctorId);
		return scheduleListbyDoctor;

	}
	

	@POST
	@Path("/updateSchedule")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateSchedule(Schedule schdule) {

		ScheduleImpl schduleImpl = ScheduleImpl.getInstance();
		Response resp = schduleImpl.updateSchedule(schdule);
		return resp;
	}

}
