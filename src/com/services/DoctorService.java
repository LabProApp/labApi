package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Doctor;
import com.beans.Response;
import com.services.Impl.DoctorImpl;

@Path("/doctor")
public class DoctorService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response add(Doctor doct) {

		System.out.println("Add Doctor =>" + doct);
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		Response resp = doctorImpl.add(doct);
	
		return resp;
	}

	@GET
	@Path("/get/{doctorId}")
	@Produces(MediaType.APPLICATION_XML)
	public Doctor get(@PathParam("doctorId") Long doctorId) {
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		Doctor doct = doctorImpl.get(doctorId);
		return doct;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_XML)
	public List<Doctor> getdoctorList() {
		List<Doctor> doctList;
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		doctList = doctorImpl.getdoctorList();
		return doctList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updatedoctor(Doctor doct) {

		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		Response resp = doctorImpl.updatedoctor(doct);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete/{doctorId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deletedoctor(@PathParam("doctorId") Long doctorId) {

		System.out.println("Delete doctor");
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		Response resp = doctorImpl.deletedoctor(doctorId);

		return resp;

	}
	@POST
	@Path("/activatedoctor/{doctorId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response activatedoctor(@PathParam("doctorId") Long doctorId) {

		System.out.println("Delete doctor");
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		Response resp = doctorImpl.activatedoctor(doctorId);

		return resp;

	}
}
