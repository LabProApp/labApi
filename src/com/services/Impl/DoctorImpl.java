package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.beans.Doctor;
import com.beans.Patient;
import com.beans.Response;

public class DoctorImpl {

	private static DoctorImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private DoctorImpl() {

	}

	public static DoctorImpl getInstance() {
		if (instance == null)
			instance = new DoctorImpl();

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

	public Response add(Doctor doctor) {

		Response resp = new Response();
		System.out.println("Add Doctor =>" + doctor);

		Long doctorId = null;
		try {
			em.getTransaction().begin();
			em.persist(doctor);

			em.getTransaction().commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return resp;
	}

	public Doctor get(Long doctorId) {

		Response resp = new Response();
		Doctor doctor = null;

		try {
			doctor = em.find(Doctor.class, doctorId);
			if (doctor == null) {
				doctor = new Doctor();
				doctor.setDocId(0L);
			}

			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");

			e.printStackTrace();
		} finally {
			// em.close();
		}

		return doctor;

	}

	public List<Doctor> getdoctorList() {
		List<Doctor> docList = new ArrayList<Doctor>();
		System.out.println("Get Entire doctor List");
		try {
			
			docList = em.createQuery("SELECT d FROM Doctor d").getResultList();

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			// em.close();
		}

		System.out.println("Entire Doctor List " + docList);
		return docList;

	}

	public Response updatedoctor(Doctor doctor) {
		Response resp = new Response();
		System.out.println("Update Doctor ==>" + doctor);

		try {

			em.getTransaction().begin();

			em.merge(doctor);
			em.getTransaction().commit();

			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return resp;
	}

	public Response deletedoctor(Long doctorId) {
		Response resp = new Response();

		System.out.println("Delete doctor");
		System.out.println("Deleting doctor  =>" + doctorId);

		try {

			em.getTransaction().begin();

			Query q = em
					.createNativeQuery("UPDATE DOCTOR set status=:status WHERE DOC_ID=:doctorId");
			q.setParameter("status", 14);
			q.setParameter("doctorId", doctorId);

			int updateCount = q.executeUpdate();
			System.out.println("Number of Doctors Deleted = " + updateCount);
			em.getTransaction().commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return resp;

	}
}
