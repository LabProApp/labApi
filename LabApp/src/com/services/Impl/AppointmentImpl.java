package com.services.Impl;

import java.util.ArrayList;
import com.beans.Appointment;
import com.beans.Response;
import com.beans.lab;

public class AppointmentImpl {

	private static AppointmentImpl instance;

	private AppointmentImpl() {

	}

	public static AppointmentImpl getInstance() {
		if (instance == null)
			instance = new AppointmentImpl();
		return instance;
	}

	public Response BookAppointment(Appointment appmnt) {
		Response resp = new Response();

		System.out.println("Book Appointment " + appmnt);
		// TODO Get Customer & Laboratory Details from appmnt Object
		// Check if now flag is true if true put scheduleDate=now
		// Check isHomePick flag is true , send a notification to
		// labRepresentative
		// Keep Initial acceptedStatus=WAITING

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public Response cancelAppointment(String appntId) {

		Response resp = new Response();
		// TODO Update acceptedStatus = CANCELLED in Appointments Table

		return resp;

	}

	public ArrayList<lab> getAppointListbyLab(String LabId) {
		ArrayList<lab> AppointListbyLab = new ArrayList<lab>();

		// TODO Fetch Appointment List by Lab ID & BranchCode

		return AppointListbyLab;

	}

	public ArrayList<lab> getAppointListbyCustomer(String CustomerId) {
		ArrayList<lab> AppointListbyCustomer = new ArrayList<lab>();

		// TODO Fetch Appointment List by Customer ID
		return AppointListbyCustomer;

	}

	public Response updateAppointment(Appointment appmnt) {

		Response resp = new Response();

		resp.setSTATUS("SUCCESS");
		return resp;
	}

}
