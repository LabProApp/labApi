package com.services.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.LabOffice;
import com.beans.Patient;
import com.beans.Response;
import com.common.Constants;

public class LabOfficeImpl {

	private static LabOfficeImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private LabOfficeImpl() {

	}

	public static LabOfficeImpl getInstance() {
		if (instance == null)
			instance = new LabOfficeImpl();
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

	public Response addLabOffice(LabOffice labOff) {
		Response resp = new Response();
		System.out.println("Add Lab Office =>" + labOff);

		Long labOfficeId = null;
		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(labOff);
			System.out.println("Lab Office Created - " + labOfficeId);
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");

			em.getTransaction().commit();
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

	public LabOffice getLabOffice(Long labOfficeId) {
		LabOffice labOffice = new LabOffice();

		Response resp = new Response();

		try {
			labOffice = em.find(LabOffice.class, labOfficeId);
			if (labOffice == null) {
				labOffice = new LabOffice();
				labOffice.setLabOfficeId(0L);
			}
			System.out.println("Lab Office - " + labOffice.getLabOfficeId());

			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return labOffice;

	}

	public List<LabOffice> getLabOfficeList() {

		List<LabOffice> labList = null;
		System.out.println("Get Entire Lab Office List");

		try {

			labList = em.createQuery("SELECT l FROM LabOffice l")
					.getResultList();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

		}

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	public Response updateLabOffice(LabOffice labOff) {

		Response resp = new Response();
		System.out.println("Update LabOffice ==>" + labOff);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(labOff);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
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

	public Response deleteLabOffice(Long labOfficeId) {

		Response resp = new Response();
		System.out.println("Delete LabOffice ==>" + labOfficeId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE LAB_OFFICE set status=:status WHERE LAB_OFFICE_ID=:labOfficeId");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("labOfficeId", labOfficeId);

			int updateCount = q.executeUpdate();

			System.out.println("Number of LAB_OFFICE Deleted = " + updateCount);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
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

	public Response activateLabOffice(Long labOfficeId) {


		Response resp = new Response();
		System.out.println("Activate LabOffice ==>" + labOfficeId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE LAB_OFFICE set status=:status WHERE LAB_OFFICE_ID=:labOfficeId");
			q.setParameter("status", Constants.ACTIVE);
			q.setParameter("labOfficeId", labOfficeId);

			int updateCount = q.executeUpdate();

			System.out.println("Number of LAB_OFFICE Activated = " + updateCount);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
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
