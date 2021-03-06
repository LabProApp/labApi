package com.services.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Patient;
import com.beans.Response;
import com.common.Constants;
import com.dao.EmManager;

public class PatientImpl {

	private static EntityManager em;

	public static PatientImpl instance;

	private PatientImpl() {

	}

	public static PatientImpl getInstance() {
		if (instance == null) {
			instance = new PatientImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}

	public Response add(Patient ptnt) {

		Response resp = new Response();
		System.out.println("Add Patient =>" + ptnt);

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.persist(ptnt);

			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");

			em.getTransaction().commit();
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");

			em.getTransaction().rollback();
			e.printStackTrace();
		}

		return resp;
	}

	public Patient get(Long patientId) {

		Response resp = new Response();
		Patient patient = null;

		try {

			patient = em.find(Patient.class, patientId);
			if (patient == null) {
				patient = new Patient();
				patient.setPatientId(0L);
			}

			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return patient;

	}

	public List<Patient> getpatientList() {
		List<Patient> ptntList = null;
		System.out.println("Get Entire patient List");
		try {
			ptntList = em.createQuery("SELECT p FROM Patient p")
					.getResultList();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			// em.close();
		}

		System.out.println("Entire Patient List " + ptntList);
		return ptntList;

	}

	public Response updatepatient(Patient ptnt) {
		Response resp = new Response();
		System.out.println("Update Patient ==>" + ptnt);

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(ptnt);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return resp;
	}

	public Response deletepatient(Long patientId) {
		Response resp = new Response();

		System.out.println("Delete patient");
		System.out.println("Deleting patient  =>" + patientId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE PATIENT set status=:status WHERE PTNT_ID=:patientId");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("patientId", patientId);

			int updateCount = q.executeUpdate();

			System.out.println("Number of Patients Deleted = " + updateCount);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return resp;

	}

	public Response activatepatient(Long patientId) {

		Response resp = new Response();

		System.out.println("Activating patient  =>" + patientId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE PATIENT set status=:status WHERE PTNT_ID=:patientId");
			q.setParameter("status", Constants.ACTIVE);
			q.setParameter("patientId", patientId);

			int updateCount = q.executeUpdate();

			System.out.println("Number of Patients Activated = " + updateCount);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return resp;

	}
}
