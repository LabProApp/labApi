package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Response;
import com.beans.Tests;
import com.common.Constants;

public class TestsImpl {

	private static TestsImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private TestsImpl() {

	}

	public static TestsImpl getInstance() {
		if (instance == null)
			instance = new TestsImpl();

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

	public Response add(Tests test) {
		Response resp = new Response();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(test);
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

	public Tests get(Long testId) {

		Response resp = new Response();
		Tests test = null;

		try {
			test = em.find(Tests.class, testId);
			if (test == null) {
				test = new Tests();
				test.setTestId(0L);
			}

			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");

			e.printStackTrace();
		} finally {

		}

		return test;

	}

	public List<Tests> gettestList() {
		List<Tests> testList = new ArrayList<Tests>();
		System.out.println("Get Entire test List");

		try {
			testList = em.createQuery("SELECT t FROM Tests t").getResultList();

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Entire Tests List " + testList);
		return testList;

	}

	public Response updatetest(Tests test) {
		Response resp = new Response();
		System.out.println("Update Tests ==>" + test);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(test);
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

	public Response deletetest(Long testId) {
		Response resp = new Response();

		System.out.println("Delete test");
		System.out.println("Deleting test  =>" + testId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query q = em
					.createNativeQuery("UPDATE TESTS set status=:status WHERE TEST_ID=:testId");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("testId", testId);

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
