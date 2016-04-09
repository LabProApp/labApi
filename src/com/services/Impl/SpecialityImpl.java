package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beans.Address;
import com.beans.Patient;
import com.beans.Speciality;
import com.beans.Speciality;
import com.beans.Response;
import com.common.Constants;

public class SpecialityImpl {

	private static SpecialityImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private SpecialityImpl() {

	}

	public static SpecialityImpl getInstance() {
		if (instance == null)
			instance = new SpecialityImpl();

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

	public Response add(Speciality spec) {
		Response resp = new Response();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(spec);
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
			em.getTransaction().commit();
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return resp;
	}

	public Speciality get(Long specId) {

		Response resp = new Response();
		Speciality spec = null;

		try {
			spec = em.find(Speciality.class, specId);
			if (spec == null) {
				spec = new Speciality();
				spec.setTestId(0L);
			}

			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");

			e.printStackTrace();
		} finally {

		}

		return spec;

	}

	public List<Speciality> getspecList() {
		List<Speciality> specList = new ArrayList<Speciality>();
		System.out.println("Get Entire spec List");

		try {
			specList = em.createQuery("SELECT t FROM Speciality t").getResultList();

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Entire Speciality List " + specList);
		return specList;

	}

	public Response updatespec(Speciality spec) {
		Response resp = new Response();
		System.out.println("Update Speciality ==>" + spec);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(spec);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return resp;
	}

	public Response deletespec(Long specId) {
		Response resp = new Response();

		System.out.println("Delete spec");
		System.out.println("Deleting spec  =>" + specId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query q = em
					.createNativeQuery("UPDATE TESTS set status=:status WHERE TEST_ID=:specId");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("specId", specId);

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

		}
		return resp;

	}
}
