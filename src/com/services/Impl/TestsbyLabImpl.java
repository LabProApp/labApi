package com.services.Impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import com.beans.Response;
import com.beans.TestsbyLab;

public class TestsbyLabImpl {

	private static TestsbyLabImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private TestsbyLabImpl() {

	}

	public static TestsbyLabImpl getInstance() {
		if (instance == null)
			instance = new TestsbyLabImpl();

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

	public Response add(TestsbyLab testsbyLab) {

		Response resp = new Response();

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(testsbyLab);
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

	public List<TestsbyLab> getTestsbyLabOffice(Long labOfficeId) {

		List<TestsbyLab> testList = new ArrayList<TestsbyLab>();
		System.out.println("Get Entire LabBranch List");
		try {
			Query q = em.createNativeQuery("SELECT * FROM TESTS_LAB where LAB_OFFICE_ID =:labOfficeId");
			q.setParameter("labOfficeId", labOfficeId);
			testList = q.getResultList();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Get Entire TestsbyLab List => " + testList);

		return testList;
		
	}

	public List<TestsbyLab> getLabsbyTests(Long testsId) {

		List<TestsbyLab> testList = new ArrayList<TestsbyLab>();
		System.out.println("Get Entire LabBranch List");
		try {
			Query q = em.createNativeQuery("SELECT * FROM TESTS_LAB where TEST_ID =:testsId");
			q.setParameter("testsId", testsId);
			testList = q.getResultList();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Get Entire TestsbyLab List => " + testList);

		return testList;
		
	}

	public List<TestsbyLab> getTestsbyLabBranch(Long labBranchCd) {

		List<TestsbyLab> testList = new ArrayList<TestsbyLab>();
		System.out.println("Get Entire TestsbyLab List");
		try {
			Query q = em.createNativeQuery("SELECT * FROM TESTS_LAB where LAB_BRANCH_CD =:labBranchCd");
			q.setParameter("labBranchCd", labBranchCd);
			testList = q.getResultList();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Get Entire TestsbyLab List => " + testList);

		return testList;
		
	}
	

	public Response updatetestsByLab(TestsbyLab testsbyLab) {

		Response resp = new Response();
		System.out.println("Update Tests ==>" + testsbyLab);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(testsbyLab);
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

	public Response deletetestByLab(Long id) {

		Response resp = new Response();

		System.out.println("Delete test");
		System.out.println("Deleting test  =>" + id);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query q = em
					.createNativeQuery("UPDATE TESTS set status=:status WHERE TEST_ID=:testId");
			q.setParameter("status", 14);
			q.setParameter("testId", id);

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
