package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.Appointment;
import com.beans.Response;
import com.beans.Schedule;
import com.common.CommonUtilities;
import com.common.Constants;

public class AppointmentImpl {

	private static AppointmentImpl instance;

	private static SessionFactory factory;

	private AppointmentImpl() {

	}

	public static AppointmentImpl getInstance() {
		if (instance == null)
			instance = new AppointmentImpl();

		try {
			if (factory == null) {
				factory = new Configuration().configure()
						.addPackage("com.beans")
						.addAnnotatedClass(Schedule.class)
						.buildSessionFactory();
			}

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return instance;
	}

	public Response BookAppointment(Appointment appmnt) {

		System.out.println("Book Appointment " + appmnt);
		// TODO Get Customer & Laboratory Details from appmnt Object
		// Check if now flag is true if true put scheduleDate=now
		// Check isHomePick flag is true , send a notification to Lab
		// Representative

		// Keep Initial acceptedStatus=WAITING

		// Get the time window for which appointment is required
		// Check the number of Booked token < number of Available Tokens in
		// Schedule.
		// Update the corresponding tokens_booked by +1

		Response resp = new Response();

		Session session = factory.openSession();
		Transaction tx = null;
		Long appmntId = null;
		try {

			ScheduleImpl schdleImpl = ScheduleImpl.getInstance();

			Schedule schedule = schdleImpl.getSchedulebyScheduleId(appmnt
					.getScheduleId());

			switch (appmnt.getWhen()) {

			case Constants.MORNING:
				if (schedule.getMorning_tokens_booked() < schedule
						.getMorning_tokens_avlbl()) {
					schedule.setMorning_tokens_booked(schedule
							.getMorning_tokens_booked() + 1);
					
					appmnt.setStartTime(CommonUtilities.getStartTime(schedule));
					appmnt.setEndTime(CommonUtilities.getEndTime(schedule));
					
					
					
					
					
				}
			case Constants.EVENING:
				if (schedule.getEvening_tokens_booked() < schedule
						.getEvening_tokens_avlbl()) {
					schedule.setEvening_tokens_booked(schedule
							.getEvening_tokens_booked() + 1);
				}
			case Constants.AFTERNOON:
				if (schedule.getAfternoon_tokens_booked() < schedule
						.getAfternoon_tokens_avlbl()) {
					schedule.setAfternoon_tokens_booked(schedule
							.getAfternoon_tokens_booked() + 1);
				}
			case Constants.NIGHT:
				if (schedule.getNight_tokens_booked() < schedule
						.getNight_tokens_avlbl()) {
					schedule.setNight_tokens_booked(schedule
							.getNight_tokens_booked() + 1);
				}

			}
		
			
			

			tx = session.beginTransaction();
			
			session.update(schedule);
			
			appmntId = (Long) session.save(appmnt);
			tx.commit();
			System.out.println("Schedule Created - " + appmntId);
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
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

}
