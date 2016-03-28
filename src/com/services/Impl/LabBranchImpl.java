package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.beans.Address;
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
			factory = new Configuration().configure()
					.addPackage("com.beans").addAnnotatedClass(LabBranch.class).addAnnotatedClass(Address.class)
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
		Long labbranchCode = null;
		try {
			tx = session.beginTransaction();
			lab_branch.getLabAddress().setAddressType("LAB_BRANCH");
			labbranchCode = (Long) session.save(lab_branch);
			tx.commit();
			System.out.println("Lab Branch Created - " + labbranchCode
					+ "Lab Office - " + lab_branch.getLabOfficeId());
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} 
		catch(ConstraintViolationException ce)
		{
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Office Id ="+lab_branch.getLabOfficeId());
			if (tx != null)
				tx.rollback();
			ce.printStackTrace();
			
		}
		catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resp;
	}

	public LabBranch getLab(Long labbranchCode) {
		LabBranch lab_branch = null;
		Response resp = new Response();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			lab_branch = (LabBranch) session
					.get(LabBranch.class, labbranchCode);
			System.out.println("Lab Branch Fetched - "
					+ lab_branch.getLabbranchCode() + "Lab Office - "
					+ lab_branch.getLabOfficeId());
			tx.commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return lab_branch;

	}

	public List<LabBranch> getLabList(Long OfficeId) {
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

	public Response updateLabBranch(LabBranch lab_branch) {

		Response resp = new Response();
		System.out.println("Update Lab Branch ==>" + lab_branch);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			lab_branch.getLabAddress().setAddressType("LAB_BRANCH");
			session.update(lab_branch);
			tx.commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} 
		catch(ConstraintViolationException ce)
		{
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Office Id ="+lab_branch.getLabOfficeId());
			if (tx != null)
				tx.rollback();
			
			
		}
		catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resp;
	}

	public Response deleteLabBranch(Long labBranchCode) {
		Response resp = new Response();

		System.out.println("Deleting Lab Branch  =>" + labBranchCode);

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LabBranch labBranch = (LabBranch) session.get(LabBranch.class,
					labBranchCode);
			if(labBranch==null)
			{
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Lab Branch with Id = " + labBranchCode);
				return resp;
			}
			labBranch.setStatus(14);
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
