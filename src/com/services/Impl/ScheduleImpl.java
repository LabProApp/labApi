package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.beans.Response;
import com.beans.Schedule;

public class ScheduleImpl {

	private static ScheduleImpl instance;
	private static SessionFactory factory;

	private ScheduleImpl() {

	}

	public static ScheduleImpl getInstance() {
		if (instance == null)
			instance = new ScheduleImpl();

		/*try {
			if (factory == null) {
				factory = new Configuration().configure()
						.addPackage("com.beans")
						.addAnnotatedClass(Schedule.class)
						.buildSessionFactory();
			}

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}*/
		return instance;
	}

	public Response addSchedule(Schedule schedule) {

		Response resp = new Response();
		System.out.println("Add Schedule =>" + schedule);
		Session session = factory.openSession();
		Transaction tx = null;
		Long ScheduleId = null;
		try {
			tx = session.beginTransaction();
			ScheduleId = (Long) session.save(schedule);
			tx.commit();
			System.out.println("Schedule Created - " + ScheduleId);
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

	public Schedule getSchedulebyScheduleId(Long ScheduleId) {

		Response resp = new Response();
		Schedule Schedule = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Schedule = (Schedule) session.get(Schedule.class, ScheduleId);
			if (Schedule == null) {
				Schedule = new Schedule();
				Schedule.setScheduleId(0L);
			}
			tx.commit();
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return Schedule;

	}

	public List<Schedule> getScheduleList() {
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		System.out.println("Get Entire Schedule List");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			scheduleList = session.createQuery("FROM Schedule").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Entire Schedule List " + scheduleList);
		return scheduleList;

	}

	public Response updateSchedule(Schedule schedule) {
		Response resp = new Response();
		System.out.println("Update Schedule ==>" + schedule);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(schedule);
			tx.commit();
			resp.setERROR_CODE("0000");
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

	public Response deleteSchedule(Long ScheduleId) {
		Response resp = new Response();

		System.out.println("Delete Schedule");
		System.out.println("Deleting Schedule  =>" + ScheduleId);

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Schedule Schedule = (Schedule) session.get(Schedule.class, ScheduleId);
			if (Schedule == null) {
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Schedule with Id = " + ScheduleId);
				return resp;
			}
			Schedule.setStatus(1);
			session.update(Schedule);
			tx.commit();
			resp.setERROR_CODE("0000");
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

	public List<Schedule> getScheduleListbyLabBranch(Long labBranchCd) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Schedule> getScheduleListbyLabOffice(Long labOfficeId) {
		
		return null;
	}

	public List<Schedule> getScheduleListbyLabRep(Long labRepId) {
	
		return null;
	}

	public List<Schedule> getScheduleListbyDoctor(Long doctorId) {
		
		return null;
	}

	public List<Schedule> getScheduleListbyHospital(Long doctorId) {
	
		return null;
	}
	
}
