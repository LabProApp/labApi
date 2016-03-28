package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Patient;
import com.beans.Response;
import com.services.Impl.PatientImpl;

@Path("/patient")
public class PatientService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response add(Patient ptnt) {

		System.out.println("Add Patient =>" + ptnt);
		PatientImpl patientImpl = PatientImpl.getInstance();
		Response resp = patientImpl.add(ptnt);
		return resp;
	}

	@GET
	@Path("/get/{patientId}")
	@Produces(MediaType.APPLICATION_XML)
	public Patient get(@PathParam("patientId") Long patientId) {
		PatientImpl patientImpl = PatientImpl.getInstance();
		Patient ptnt = patientImpl.get(patientId);
		return ptnt;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_XML)
	public List<Patient> getpatientList() {
		List<Patient> ptntList;
		PatientImpl patientImpl = PatientImpl.getInstance();
		ptntList = patientImpl.getpatientList();
		return ptntList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updatepatient(Patient ptnt) {

		PatientImpl patientImpl = PatientImpl.getInstance();
		Response resp = patientImpl.updatepatient(ptnt);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete/{patientId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deletepatient(@PathParam("patientId") Long patientId) {

		System.out.println("Delete patient");
		PatientImpl patientImpl = PatientImpl.getInstance();
		Response resp = patientImpl.deletepatient(patientId);

		return resp;

	}
}
