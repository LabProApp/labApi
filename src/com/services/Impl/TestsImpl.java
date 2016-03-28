package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beans.Address;
import com.beans.Tests;
import com.beans.Response;

public class TestsImpl {

	private static TestsImpl instance;
	private static SessionFactory factory;

	private TestsImpl() {

	}

	public static TestsImpl getInstance() {
		if (instance == null)
			instance = new TestsImpl();

		try {
			if (factory == null) {
				factory = new Configuration().configure()
						.addPackage("com.beans").addAnnotatedClass(Tests.class)
						.addAnnotatedClass(Address.class).buildSessionFactory();
			}

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return instance;
	}

	public Response add(Tests test) {

		Response resp = new Response();
		Session session = factory.openSession();
		Transaction tx = null;
		Long testId = null;
		try {
			tx = session.beginTransaction();
			testId = (Long) session.save(test);
			tx.commit();
			System.out.println("Tests Created - " + testId);
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

	public Tests get(Long testId) {

		Response resp = new Response();
		Tests test = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			test = (Tests) session.get(Tests.class, testId);
			if (test == null) {
				test = new Tests();
				test.setTestId(0L);
			}
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

		return test;

	}

	public List<Tests> gettestList() {
		List<Tests> testList = new ArrayList<Tests>();
		System.out.println("Get Entire test List");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			testList = session.createQuery("FROM Tests").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Entire Tests List " + testList);
		return testList;

	}

	public Response updatetest(Tests test) {
		Response resp = new Response();
		System.out.println("Update Tests ==>" + test);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.merge(test);
			tx.commit();
			resp.setERROR_CODE("0000");
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

	public Response deletetest(Long testId) {
		Response resp = new Response();

		System.out.println("Delete test");
		System.out.println("Deleting test  =>" + testId);

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Tests test = (Tests) session.get(Tests.class, testId);
			if (test == null) {
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Tests with Id = " + testId);
				return resp;
			}
			test.setStatus(14);
			session.update(test);
			tx.commit();
			resp.setERROR_CODE("0000");
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
