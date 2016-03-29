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
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.beans.Address;
import com.beans.LabBranch;
import com.beans.LabOffice;
import com.beans.Response;

public class LabBranchImpl {

	private static LabBranchImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private LabBranchImpl() {

	}

	public static LabBranchImpl getInstance() {
		if (instance == null)
			instance = new LabBranchImpl();
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

	public Response addLab(LabBranch lab_branch) {
		Response resp = new Response();
		System.out.println("Add Lab Branch =>" + lab_branch);

		Long labbranchCode = null;
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(lab_branch);

			System.out.println("Lab Branch Created - " + labbranchCode
					+ "Lab Office - " + lab_branch.getLabOfficeId());
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");

			em.getTransaction().commit();
		} catch (ConstraintViolationException ce) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Office Id ="
					+ lab_branch.getLabOfficeId());
			em.getTransaction().rollback();
			ce.printStackTrace();

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

	public LabBranch getLab(Long labbranchCode) {
		LabBranch lab_branch = null;
		Response resp = new Response();

		try {
			lab_branch = em.find(LabBranch.class, labbranchCode);
			if (lab_branch == null) {
				lab_branch = new LabBranch();
				lab_branch.setLabOfficeId(0L);
				lab_branch.setLabbranchCode(0L);
			}
			System.out.println("Lab Branch Fetched - "
					+ lab_branch.getLabbranchCode() + "Lab Office - "
					+ lab_branch.getLabOfficeId());

		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");

			e.printStackTrace();
		} finally {

		}

		return lab_branch;

	}

	public List<LabBranch> getLabList(Long OfficeId) {
		List<LabBranch> labList = new ArrayList<LabBranch>();
		System.out.println("Get Entire LabBranch List");

		try {

			Query q = em
					.createNativeQuery("SELECT * FROM LAB_BRANCH where LAB_OFFICE_ID =:OfficeId");
			q.setParameter("OfficeId", OfficeId);

			labList = q.getResultList();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Get Entire Lab Branches List => " + labList);

		return labList;

	}

	public Response updateLabBranch(LabBranch lab_branch) {

		Response resp = new Response();
		System.out.println("Update Lab Branch ==>" + lab_branch);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(lab_branch);
			em.getTransaction().commit();

			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (ConstraintViolationException ce) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Office Id ="
					+ lab_branch.getLabOfficeId());
			em.getTransaction().rollback();
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

	public Response deleteLabBranch(Long labBranchCode) {
		Response resp = new Response();

		System.out.println("Deleting Lab Branch  =>" + labBranchCode);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE LAB_BRANCH set status=:status WHERE LAB_BRANCH_CD=:labBranchCode");
			q.setParameter("status", 14);
			q.setParameter("labBranchCode", labBranchCode);

			int updateCount = q.executeUpdate();

			System.out.println("Number of LAB_BRANCH Deleted = " + updateCount);
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
