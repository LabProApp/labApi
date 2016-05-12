package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

import com.beans.LabRep;
import com.beans.Response;
import com.common.Constants;
import com.dao.EmManager;

public class LabRepImpl {

	private static EntityManager em;

	public static LabRepImpl instance;

	private LabRepImpl() {

	}

	public static LabRepImpl getInstance() {
		if (instance == null) {
			instance = new LabRepImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}

	public Response addLab(LabRep lab_rep) {
		Response resp = new Response();
		System.out.println("Add Lab Rep =>" + lab_rep);

		Long labRepId = null;
		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(lab_rep);
			em.getTransaction().commit();
			System.out.println("Lab Rep Created - " + labRepId);
			System.out.println("Lab Branch  - " + lab_rep.getLabbranchCode());
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (ConstraintViolationException ce) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Branch Id ="
					+ lab_rep.getLabbranchCode());
			em.getTransaction().rollback();
			ce.printStackTrace();

		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return resp;
	}

	public LabRep get(Long labRepId) {
		LabRep lab_rep = null;
		Response resp = new Response();

		try {

			lab_rep = (LabRep) em.find(LabRep.class, labRepId);
			if (lab_rep == null) {
				lab_rep = new LabRep();
				lab_rep.setLabRepresentativeId(0L);
				lab_rep.setLabbranchCode(0L);
			}
			System.out.println("Lab Rep Fetched - "
					+ lab_rep.getLabbranchCode() + " Rep ID ="
					+ lab_rep.getLabRepresentativeId());

			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE(Constants.RESP_SUCCESS);
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_DBERROR);

			e.printStackTrace();
		} finally {

		}

		return lab_rep;

	}

	public List<LabRep> getLabRepList(Long LabBranchCode) {

		// TODO: Fetch this List for a Particular Lab BRanch Code
		List<LabRep> labRepList = new ArrayList<LabRep>();
		List<Object[]> objList = new ArrayList<Object[]>();
		System.out.println("Get Entire LabRep List for BranchCode = "
				+ LabBranchCode);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query query = em
					.createNativeQuery("SELECT  LAB_REP_ID,PRIM_MOBILE,REP_NAME,LAB_BRANCH_CD,STATUS FROM LAB_BRANCH_REP where LAB_BRANCH_CD =:LabBranchCode");
			query.setParameter("LabBranchCode", LabBranchCode);
			objList = query.getResultList();
			labRepList = new ArrayList<LabRep>(objList.size());
			for (Object obj[] : objList) {

				LabRep lr = new LabRep();
				if (obj[0] instanceof Number) {
					lr.setLabRepresentativeId(((Number) obj[0]).longValue()); // LAB_REP_ID
				}
				if (obj[1] instanceof String) {
					lr.setPrimaryMobileNo((String) obj[1]); // PRIM_MOBILE
				}
				if (obj[2] instanceof String) {
					lr.setRepName((String) obj[2]); // REP_NAME
				}
				if (obj[3] instanceof Number) {
					lr.setLabbranchCode(((Number) obj[3]).longValue()); // LAB_BRANCH_CD
				}
				if (obj[4] instanceof Number) {
					lr.setStatus(((Number) obj[4]).intValue()); // STATUS
				}
				labRepList.add(lr);
			}

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Get Entire Lab Rep List => " + labRepList);

		return labRepList;

	}

	public Response updateLab(LabRep lab_rep) {

		Response resp = new Response();
		System.out.println("Update Lab Branch ==>" + lab_rep);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(lab_rep);
			em.getTransaction().commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE(Constants.RESP_SUCCESS);
		} catch (ConstraintViolationException ce) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_NORECORD);
			resp.setERROR_MESSAGE("No Lab Branch Exists with Branch Id ="
					+ lab_rep.getLabbranchCode());

		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_DBERROR);
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}
		return resp;
	}

	public Response delete(Long labRepId) {
		Response resp = new Response();

		System.out.println("Deleting Lab Representative  =>" + labRepId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			LabRep lab_rep = (LabRep) em.find(LabRep.class, labRepId);
			if (lab_rep == null) {
				resp.setERROR_CODE(Constants.RESP_NORECORD);
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Lab Rep with Id = " + labRepId);
				return resp;
			}
			lab_rep.setStatus(Constants.DELETED);
			em.merge(lab_rep);
			em.getTransaction().commit();
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}
		return resp;
	}

	public Response activateLabRep(Long labRepId) {

		Response resp = new Response();

		System.out.println("Deleting Lab Representative  =>" + labRepId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			LabRep lab_rep = (LabRep) em.find(LabRep.class, labRepId);
			if (lab_rep == null) {
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Lab Rep with Id = " + labRepId);
				return resp;
			}
			lab_rep.setStatus(Constants.ACTIVE);
			em.merge(lab_rep);
			em.getTransaction().commit();
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
