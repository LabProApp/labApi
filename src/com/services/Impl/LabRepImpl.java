package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.beans.LabRep;
import com.beans.Response;

public class LabRepImpl {

	private static LabRepImpl instance;
	private static SessionFactory factory;

	private LabRepImpl() {

	}

	public static LabRepImpl getInstance() {
		if (instance == null)
			instance = new LabRepImpl();
		/*try {
			factory = new Configuration().configure()
					.addPackage("com.beans").addAnnotatedClass(LabRep.class).addAnnotatedClass(LabRep.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}*/
		return instance;
	}

	public Response addLab(LabRep lab_rep) {
		Response resp = new Response();
		System.out.println("Add Lab Rep =>" + lab_rep);
		Session session = factory.openSession();
		Transaction tx = null;
		Long labRepId = null;
		try {
			
			tx = session.beginTransaction();
			labRepId = (Long) session.save(lab_rep);
			tx.commit();
			System.out.println("Lab Rep Created - " + labRepId);
			System.out.println("Lab Branch  - " + lab_rep.getLabbranchCode());
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		}
		catch(ConstraintViolationException ce)
		{
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Branch Id ="+lab_rep.getLabbranchCode());
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

	public LabRep getLab(Long labRepId) {
		LabRep lab_rep = null;
		Response resp = new Response();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			lab_rep = (LabRep) session
					.get(LabRep.class, labRepId);
			System.out.println("Lab Rep Fetched - "
					+ lab_rep.getLabbranchCode()  +" Rep ID =" + lab_rep.getLabRepresentativeId());
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

		return lab_rep;

	}

	public List<LabRep> getLabRepList(Long LabBranchCode) {
		
		//TODO: Fetch this List for a Particular Lab BRanch Code
		List<LabRep> labRepList = new ArrayList<LabRep>();
		System.out.println("Get Entire LabRep List for BranchCode = " +LabBranchCode);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			labRepList = session.createQuery("FROM LAB_REP").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Get Entire Lab Rep List => " + labRepList);

		return labRepList;

	}

	public Response updateLab(LabRep lab_rep) {

		Response resp = new Response();
		System.out.println("Update Lab Branch ==>" + lab_rep);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.update(lab_rep);
			tx.commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} 
		catch(ConstraintViolationException ce)
		{
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Branch Id ="+lab_rep.getLabbranchCode());
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

	public Response deleteLabRep(Long labRepId) {
		Response resp = new Response();

		System.out.println("Deleting Lab Representative  =>" + labRepId);

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LabRep lab_rep = (LabRep) session.get(LabRep.class,
					labRepId);
			if(lab_rep==null)
			{
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Lab Rep with Id = " + labRepId);
				return resp;
			}
			lab_rep.setStatus(14);
			session.update(lab_rep);
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

	public Response activateLabRep(Long labBranchCode) {
		// TODO Auto-generated method stub
		return null;
	}
}
