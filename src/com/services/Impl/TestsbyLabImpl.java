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
import com.common.Constants;
import com.dto.TestByLabDto;

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

	/*
	 * public List<TestsbyLab> getTestsbyLabOffice(Long labOfficeId) {
	 * 
	 * List<TestsbyLab> testList = new ArrayList<TestsbyLab>();
	 * System.out.println("Get Entire LabBranch List"); try { Query q =
	 * em.createNativeQuery
	 * ("SELECT * FROM TESTS_LAB where LAB_OFFICE_ID =:labOfficeId");
	 * q.setParameter("labOfficeId", labOfficeId); testList = q.getResultList();
	 * } catch (HibernateException e) {
	 * 
	 * e.printStackTrace(); } finally {
	 * 
	 * }
	 * 
	 * System.out.println("Get Entire TestsbyLab List => " + testList);
	 * 
	 * return testList;
	 * 
	 * }
	 * 
	 * public List<TestsbyLab> getLabsbyTests(Long testsId) {
	 * 
	 * List<TestsbyLab> testList = new ArrayList<TestsbyLab>();
	 * System.out.println("Get Entire LabBranch List"); try { Query q =
	 * em.createNativeQuery("SELECT * FROM TESTS_LAB where TEST_ID =:testsId");
	 * q.setParameter("testsId", testsId); testList = q.getResultList(); } catch
	 * (HibernateException e) {
	 * 
	 * e.printStackTrace(); } finally {
	 * 
	 * }
	 * 
	 * System.out.println("Get Entire TestsbyLab List => " + testList);
	 * 
	 * return testList;
	 * 
	 * }
	 */
	public List<TestByLabDto> getLabBranchbyCityTests(String city,
			String testName) {

		List<TestByLabDto> testByLabDtoList = null;
		List<Object[]> objList;
		System.out.println("Get Entire LabBranch List");
		try {
			Query q = em
					.createNativeQuery("SELECT lb.LAB_BRANCH_CD,lb.LAB_NAME,lb.LAB_BR_OWNER,lb.PRIM_MOBILE,lb.EMAIL_ID,lb.IMG_PATH,"
							+ "a.ADD_LINE1,a.ADD_LINE2,a.ADD_LINE3,a.CITY,a.STATE,a.ZIP,a.COUNTRY"
							+ "t.TEST_NAME,t.LOWER_VALUE,tl.TEST_TYPE,tl.DESCRIPTION,tl.TEST_STEPS"
							+ "tl.HOME_PICK,tl.FEE,tl.UPPER_VALUE,tl.UNITS,"
							+ "FROM LAB_BRANCH lb,TESTS_LAB tl,TESTS t,ADDRESS a "
							+ "WHERE  tl.LAB_BRANCH_CD=l.LAB_BRANCH_CD "
							+ "AND tl.TEST_ID=t.TEST_ID"
							+ "AND l.ADDRESS_ID=a.labAddress_ADDRESS_ID "
							+ "AND a.CITY= :city"
							+ "AND t.TEST_NAME =:testName"
							+ "AND lb.STATUS =:status");
			q.setParameter("city", city);
			q.setParameter("testName", testName);
			q.setParameter("status", Constants.ACTIVE);
			objList = q.getResultList();

			testByLabDtoList = new ArrayList<TestByLabDto>(objList.size());

			for (Object obj[] : objList) {

				TestByLabDto tlDto = new TestByLabDto();
				if (obj[0] instanceof Number) {
					tlDto.getLb().setLabbranchCode(((Number) obj[0]).longValue()); // LAB_BRANCH_CD
				}
				if (obj[1] instanceof Number) {
					tlDto.getLb().setLabName(((String) obj[1])); // LAB_NAME
				}
				

				testByLabDtoList.add(tlDto);
			}

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Get Entire TestsbyLab List => " + testByLabDtoList);

		return testByLabDtoList;

	}

	public List<TestsbyLab> getTestsbyLabBranch(Long labBranchCd) {

		List<TestsbyLab> testList = new ArrayList<TestsbyLab>();
		System.out.println("Get Entire TestsbyLab List");
		try {
			Query q = em
					.createNativeQuery("SELECT * FROM TESTS_LAB where LAB_BRANCH_CD =:labBranchCd");
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
					.createNativeQuery("UPDATE TESTS_LAB set status=:status WHERE TEST_ID=:testId");
			q.setParameter("status", Constants.DELETED);
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
