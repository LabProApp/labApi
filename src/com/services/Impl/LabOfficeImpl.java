package com.services.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.Address;
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
			if (factory == null) {
				factory = new Configuration().configure()
						.addPackage("com.beans")
						.addAnnotatedClass(LabOffice.class)
						.addAnnotatedClass(Address.class).buildSessionFactory();
			}
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return instance;
	}

	public Response addLabOffice(LabOffice labOff) {
		Response resp = new Response();
		System.out.println("Add Lab Office =>" + labOff);
		Session session = factory.openSession();
		Transaction tx = null;
		Long labOfficeId = null;
		try {
			tx = session.beginTransaction();
			labOfficeId = (Long) session.save(labOff);
			tx.commit();
			System.out.println("Lab Office Created - " + labOfficeId);
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resp;
	}

	public LabOffice getLabOffice(Long labOfficeId) {
		LabOffice labOffice = new LabOffice();

		Response resp = new Response();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			labOffice = (LabOffice) session.get(LabOffice.class, labOfficeId);
			if (labOffice == null) {
				labOffice = new LabOffice();
				labOffice.setLabOfficeId(0L);
			}
			System.out.println("Lab Office - " + labOffice.getLabOfficeId());
			tx.commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return labOffice;

	}

	public List<LabOffice> getLabOfficeList() {
		

		List<LabOffice> labList=null;
		System.out.println("Get Entire Lab Office List");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			labList = session.createQuery("FROM LabOffice").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	public Response updateLabOffice(LabOffice labOffice) {


		Response resp = new Response();
		System.out.println("Update LabOffice ==>" + labOffice);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		/*	LabOffice b = (LabOffice) session.get(LabOffice.class,
					labOffice.getLabOfficeId());
			b = labOffice;*/
			session.update(labOffice);
			tx.commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resp;
	}

	public Response deleteLabOffice(Long labOfficeId) {

		Response resp = new Response();
		System.out.println("Delete LabOffice ==>" + labOfficeId);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LabOffice b = (LabOffice) session.get(LabOffice.class,labOfficeId);
			if(b==null)
			{
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Lab Office with Id = " + labOfficeId);
				session.close();
				return resp;
			}
			b.setStatus("DELETED");
			session.update(b);
			tx.commit();
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resp;
	}
}
