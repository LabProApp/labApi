package com.services.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Response;
import com.beans.Reviews;
import com.common.Constants;
import com.dao.EmManager;

public class ReviewImpl {

	// String query =
	// "SELECT REVIEW_ID,PTNT_ID,DOCTOR_ID,LAB_OFFICE_ID,LAB_BRANCH_CD,RATING,RATING_DT,REVIEW FROM REVIEWS ";
	String query = "SELECT * FROM REVIEWS ";

	private static EntityManager em;

	public static ReviewImpl instance;

	private ReviewImpl() {

	}

	public static ReviewImpl getInstance() {
		if (instance == null) {
			instance = new ReviewImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}

	public Response add(Reviews review) {

		Response resp = new Response();
		System.out.println("Add Reviews =>" + review);

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.persist(review);

			resp.setERROR_CODE(Constants.RESP_SUCCESS);
			resp.setSTATUS("SUCCESS");

			em.getTransaction().commit();
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_DBERROR);
			em.getTransaction().rollback();
			e.printStackTrace();
		} catch (Exception e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_CONNERROR);
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		return resp;
	}

	public List<Reviews> getReviewforDoctor(Long docId) {
		Response resp = new Response();

		//List<Object[]> objlist = null;
		List<Reviews> reviewList = null;
		try {

			Query q = em.createNativeQuery(query + "where DOCTOR_ID=:docId",
					Reviews.class);
			q.setParameter("docId", docId);
			reviewList = q.getResultList();
			// objlist = q.getResultList();
			// reviewList = populateReviewList(objlist);

		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return reviewList;

	}

	public List<Reviews> getReviewforLabBranch(Long branchCd) {
		Response resp = new Response();

	//	List<Object[]> objlist = null;
		List<Reviews> reviewList = null;
		try {

			Query q = em.createNativeQuery(query
					+ "where LAB_BRANCH_CD=:branchCd", Reviews.class);
			q.setParameter("branchCd", branchCd);
			reviewList = q.getResultList();
			// objlist = q.getResultList();
			// reviewList = populateReviewList(objlist);

		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return reviewList;

	}

	/*private List<Reviews> populateReviewList(List<Object[]> objlist) {
		List<Reviews> reviewList = new ArrayList<Reviews>(objlist.size());
		for (Object obj[] : objlist) {

			Reviews review = new Reviews();

			if (obj[0] instanceof Number) {
				review.setReviewId(((Number) obj[0]).longValue()); // ID
			}

			if (obj[1] instanceof Number) {
				review.setRatingCustomerId(((Number) obj[2]).longValue()); // ID
			}
			if (obj[2] instanceof Number) {
				review.setDoctorId(((Number) obj[2]).longValue()); // ID
			}
			if (obj[3] instanceof Number) {
				review.setLabOfficeId(((Number) obj[3]).longValue()); // ID
			}
			if (obj[4] instanceof Number) {
				review.setBranchCode(((Number) obj[4]).longValue()); // STATUS
			}
			if (obj[5] instanceof Number) {
				review.setStar_rating(((Number) obj[5]).intValue()); // STATUS
			}
			if (obj[6] instanceof Date) {
				review.setRatingDate((Date) obj[6]); // OTP SetTime
			}
			if (obj[7] instanceof String) {
				review.setReviewDescription(((String) obj[7])); // Name
			}
			reviewList.add(review);
		}
		
		return reviewList;
	}*/

}
