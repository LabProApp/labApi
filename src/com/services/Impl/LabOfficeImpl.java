package com.services.Impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.LabOffice;
import com.beans.Response;

public class LabOfficeImpl {

	private static LabOfficeImpl instance;
	private static SessionFactory factory;

	private LabOfficeImpl() {

	}

	public static LabOfficeImpl getInstance() {
		if (instance == null)
			instance = new LabOfficeImpl();
		try {
			factory = new Configuration().configure()
					.addPackage("com.beans").addAnnotatedClass(LabOffice.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return instance;
	}

	public Response addLab(LabOffice labOff) {
		Response resp = new Response();
		System.out.println("Add Lab Office =>" + labOff);
		Session session = factory.openSession();
		Transaction tx = null;
		String labOfficeId = null;
		try {
			tx = session.beginTransaction();
			labOfficeId = (String) session.save(labOff);
			tx.commit();
			System.out.println("Lab Office Created - " + labOfficeId);
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

	public LabOffice getLab(String labOfficeId) {
		LabOffice labOffice = new LabOffice();

		
		Response resp = new Response();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			labOffice = (LabOffice) session
					.get(LabOffice.class, labOfficeId);
			System.out.println("Lab Office - "
					+ labOffice.getLabOfficeId());
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

		return labOffice;

	}

	public ArrayList<LabOffice> getLabList() {
		ArrayList<LabOffice> labList = new ArrayList<LabOffice>();
		LabOffice lr = new LabOffice();
		System.out.println("Get Entire Lab List");
		lr.setLabOfficeId("10");
		lr.setLabName("PATIALA LAB");
		labList.add(lr);
		LabOffice lr2 = new LabOffice();
		lr2.setLabOfficeId("20");
		lr2.setLabName("CHANDIGARH LAB");
		labList.add(lr2);

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	public Response updateLab(LabOffice b) {

		Response resp = new Response();

		System.out.println("Update Lab => " + b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public Response deleteLab(String labId) {
		Response resp = new Response();
		System.out.println("Delete Lab");
		System.out.println("Lab Id =" + labId);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
}
