package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import com.beans.Appointment;
import com.beans.Response;
import com.beans.Schedule;
import com.common.Constants;

public class AppointmentImpl {

	private static AppointmentImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private AppointmentImpl() {

	}

	public static AppointmentImpl getInstance() {
		if (instance == null) {
			instance = new AppointmentImpl();
		}

		try {
			if (entityManagerFactory == null || em == null) {
				entityManagerFactory = Persistence
						.createEntityManagerFactory("mediapp");
				em = entityManagerFactory.createEntityManager();

			}

		} catch (Exception ex) {
			System.err.println("Failed to create entityManagerFactory object."
					+ ex);
			ex.printStackTrace();
		}
		return instance;
	}

	public Response BookAppointment(Appointment appmnt) {

		System.out.println("Book Appointment " + appmnt);
		// TODO Get Customer & Laboratory Details from appmnt Object

		// Check isHomePick flag is true , send a notification to Lab
		// Representative

		// Keep Initial acceptedStatus=WAITING

		// Set the token_num for the time window for which appointment is
		// required
		// Check the number of Booked token < number of Available Tokens in
		// Schedule.
		// Update the corresponding tokens_booked - Concatenate the token_num to
		// getMorning_tokens_booked

		Response resp = new Response();

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			ScheduleImpl schdleImpl = ScheduleImpl.getInstance();

			Schedule schedule = schdleImpl.getSchedulebyScheduleId(appmnt
					.getScheduleId());

			switch (appmnt.getShift()) {

			case Constants.MORNING:

				// appmnt.setStartTime(CommonUtilities.getStartTime(schedule));
				// appmnt.setEndTime(CommonUtilities.getEndTime(schedule));

			case Constants.EVENING:

			}

			em.merge(schedule);

			em.persist(appmnt);
			em.getTransaction().commit();
			System.out.println("Schedule Created - " + appmnt.getAppntmntId());
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return resp;
	}

	public Response cancelAppointment(Long appntId) {

		Response resp = new Response();
		// TODO Update acceptedStatus = CANCELLED in Appointments Table

		return resp;

	}

	public List<Appointment> getAppointListbyLab(Long LabId) {
		List<Appointment> AppointListbyLab = new ArrayList<Appointment>();

		// TODO Fetch Appointment List by Lab ID & BranchCode

		return AppointListbyLab;

	}

	public List<Appointment> getAppointListbyCustomer(Long CustomerId) {
		List<Appointment> AppointListbyCustomer = new ArrayList<Appointment>();

		// TODO Fetch Appointment List by Customer ID
		return AppointListbyCustomer;

	}

	public List<Appointment> getAppointListbyDoctor(Long DoctorId) {
		ArrayList<Appointment> AppointListbyCustomer = new ArrayList<Appointment>();

		// TODO Fetch Appointment List by Customer ID
		return AppointListbyCustomer;

	}

	public Response updateAppointment(Appointment appmnt) {

		Response resp = new Response();

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	int count_bookedTokens(String bookedTokens) {

		return 0;
	}

}
