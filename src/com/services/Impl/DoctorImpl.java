package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beans.Address;
import com.beans.Doctor;
import com.beans.Response;

public class DoctorImpl {

	private static DoctorImpl instance;
	private static SessionFactory factory;

	private DoctorImpl() {

	}

	public static DoctorImpl getInstance() {
		if (instance == null)
			instance = new DoctorImpl();

		try {
			if (factory == null) {
				factory = new Configuration().configure()
						.addPackage("com.beans")
						.addAnnotatedClass(Doctor.class)
						.addAnnotatedClass(Address.class).buildSessionFactory();
			}
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return instance;
	}

	public Response add(Doctor cust) {

		Response resp = new Response();
		System.out.println("Add Doctor =>" + cust);
		Session session = factory.openSession();
		Transaction tx = null;
		Long doctorId = null;
		try {
			tx = session.beginTransaction();
			doctorId = (Long) session.save(cust);
			tx.commit();
			System.out.println("Doctor Created - " + doctorId);
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
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

	public Doctor get(Long doctorId) {

		Response resp = new Response();
		Doctor doctor = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			doctor = (Doctor) session.get(Doctor.class, doctorId);
			if (doctor == null) {
				doctor = new Doctor();
				doctor.setDocId(0L);
			}
			tx.commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return doctor;

	}

	public List<Doctor> getdoctorList() {
		List<Doctor> custList = new ArrayList<Doctor>();
		System.out.println("Get Entire doctor List");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			custList = session.createQuery("FROM Doctor").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Entire Doctor List " + custList);
		return custList;

	}

	public Response updatedoctor(Doctor doctor) {
		Response resp = new Response();
		System.out.println("Update Doctor ==>" + doctor);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		
			session.update(doctor);
			tx.commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
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

	public Response deletedoctor(Long doctorId) {
		Response resp = new Response();

		System.out.println("Delete doctor");
		System.out.println("Deleting doctor  =>" + doctorId);

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Doctor doctor = (Doctor) session.get(Doctor.class, doctorId);
			if(doctor==null)
			{
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Doctor with Id = " + doctorId);
				return resp;
			}
			doctor.setStatus("DELETED");
			session.update(doctor);
			tx.commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
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
