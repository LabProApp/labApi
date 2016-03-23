package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.beans.LabBranch;
import com.beans.Response;

public class LabBranchImpl {

	private static LabBranchImpl instance;
	private static SessionFactory factory;

	private LabBranchImpl() {

	}

	public static LabBranchImpl getInstance() {
		if (instance == null)
			instance = new LabBranchImpl();
		try {
			factory = new AnnotationConfiguration().configure()
					.addPackage("com.beans").addAnnotatedClass(LabBranch.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return instance;
	}

	public Response addLab(LabBranch lab_branch) {
		Response resp = new Response();
		System.out.println("Add Lab Branch =>" + lab_branch);
		Session session = factory.openSession();
		Transaction tx = null;
		String labbranchCode = null;
		try {
			tx = session.beginTransaction();
			labbranchCode = (String) session.save(lab_branch);
			tx.commit();
			System.out.println("Lab Branch Created - " + labbranchCode
					+ "Lab Office - " + lab_branch.getLabOfficeId());
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resp;
	}

	public LabBranch getLab(String LAB_BRANCH_CD) {
		LabBranch lab_branch = null;
		Response resp = new Response();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			lab_branch = (LabBranch) session
					.get(LabBranch.class, LAB_BRANCH_CD);
			System.out.println("Lab Branch Fetched - "
					+ lab_branch.getLabbranchCode() + "Lab Office - "
					+ lab_branch.getLabOfficeId());
			tx.commit();
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return lab_branch;

	}

	public List<LabBranch> getLabList() {
		List<LabBranch> labList = new ArrayList<LabBranch>();
		System.out.println("Get Entire LabBranch List");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			labList = session.createQuery("FROM LAB_BRANCH").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Get Entire Lab Branches List => " + labList);

		return labList;

	}

	public Response updateLab(LabBranch lab_branch) {

		Response resp = new Response();
		System.out.println("Update Lab Branch ==>" + lab_branch);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LabBranch lab_branch_get = (LabBranch) session.get(LabBranch.class,
					lab_branch.getLabbranchCode());
			lab_branch_get = lab_branch;
			session.update(lab_branch_get);
			tx.commit();
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resp;
	}

	public Response deleteLab(String labBranchCode) {
		Response resp = new Response();

		System.out.println("Deleting Lab Branch  =>" + labBranchCode);

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LabBranch labBranch = (LabBranch) session.get(LabBranch.class,
					labBranchCode);
			labBranch.setStatus("DELETED");
			session.update(labBranch);
			tx.commit();
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resp;
	}
}
