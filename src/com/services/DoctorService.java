package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public Doctor get(@QueryParam("doctorId") Long doctorId) {
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

	@GET
	@Path("/getDoctorbyCity_Spec")
	
	@Produces(MediaType.APPLICATION_XML)
	public List<Doctor> getDoctorbyCity_Spec(@QueryParam("city") String city,@QueryParam("state") String state,
			@QueryParam("spec") String spec) {
		List<Doctor> doctList;
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		doctList = doctorImpl.getDoctorbyCity_Spec(city,spec,state);
		return doctList;

	}
	@GET
	@Path("/getDoctorbyGPS_Spec")
	@Produces(MediaType.APPLICATION_XML)
	public List<Doctor> getDoctorbyGPS_Spec() {
		List<Doctor> doctList;
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		doctList = doctorImpl.getDoctorbyGPS_Spec();
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
	@Path("/delete")
	@Produces(MediaType.APPLICATION_XML)
	public Response deletedoctor(@QueryParam("doctorId") Long doctorId) {

		System.out.println("Delete doctor");
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		Response resp = doctorImpl.deletedoctor(doctorId);

		return resp;

	}
	@POST
	@Path("/activatedoctor")
	@Produces(MediaType.APPLICATION_XML)
	public Response activatedoctor(@QueryParam("doctorId") Long doctorId) {

		System.out.println("Delete doctor");
		DoctorImpl doctorImpl = DoctorImpl.getInstance();
		Response resp = doctorImpl.activatedoctor(doctorId);

		return resp;

	}
}
