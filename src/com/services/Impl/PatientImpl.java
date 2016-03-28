package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beans.Address;
import com.beans.Patient;
import com.beans.Response;
import com.common.Constants;

public class PatientImpl {

	private static PatientImpl instance;
	private static SessionFactory factory;

	private PatientImpl() {

	}

	public static PatientImpl getInstance() {
		if (instance == null)
			instance = new PatientImpl();

		try {
			if (factory == null) {
				factory = new Configuration().configure()
						.addPackage("com.beans")
						.addAnnotatedClass(Patient.class)
						.addAnnotatedClass(Address.class).buildSessionFactory();
			}

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return instance;
	}

	public Response add(Patient ptnt) {

		Response resp = new Response();
		System.out.println("Add Patient =>" + ptnt);
		Session session = factory.openSession();
		Transaction tx = null;
		Long patientId = null;
		try {
			ptnt.getPatientAddress().setAddressType(Constants.PATIENT);
			tx = session.beginTransaction();
			patientId = (Long) session.save(ptnt);
			tx.commit();
			System.out.println("Patient Created - " + patientId);
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

	public Patient get(Long patientId) {

		Response resp = new Response();
		Patient patient = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			patient = (Patient) session.get(Patient.class, patientId);
			if (patient == null) {
				patient = new Patient();
				patient.setPatientId(0L);
			}
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

		return patient;

	}

	public List<Patient> getpatientList() {
		List<Patient> ptntList = new ArrayList<Patient>();
		System.out.println("Get Entire patient List");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ptntList = session.createQuery("FROM Patient").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Entire Patient List " + ptntList);
		return ptntList;

	}

	public Response updatepatient(Patient ptnt) {
		Response resp = new Response();
		System.out.println("Update Patient ==>" + ptnt);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			session.merge(ptnt); 
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

	public Response deletepatient(Long patientId) {
		Response resp = new Response();

		System.out.println("Delete patient");
		System.out.println("Deleting patient  =>" + patientId);

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Patient patient = (Patient) session.get(Patient.class, patientId);
			if (patient == null) {
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Patient with Id = " + patientId);
				return resp;
			}
			patient.setStatus(14);
			session.merge(patient);
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
}
