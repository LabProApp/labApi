package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beans.Address;
import com.beans.Customer;
import com.beans.Response;

public class CustomerImpl {

	private static CustomerImpl instance;
	private static SessionFactory factory;

	private CustomerImpl() {

	}

	public static CustomerImpl getInstance() {
		if (instance == null)
			instance = new CustomerImpl();

		try {
			if (factory == null) {
				factory = new Configuration().configure()
						.addPackage("com.beans")
						.addAnnotatedClass(Customer.class)
						.addAnnotatedClass(Address.class).buildSessionFactory();
			}

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return instance;
	}

	public Response add(Customer cust) {

		Response resp = new Response();
		System.out.println("Add Customer =>" + cust);
		Session session = factory.openSession();
		Transaction tx = null;
		Long customerId = null;
		try {
			tx = session.beginTransaction();
			customerId = (Long) session.save(cust);
			tx.commit();
			System.out.println("Customer Created - " + customerId);
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

	public Customer get(Long customerId) {

		Response resp = new Response();
		Customer customer = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			customer = (Customer) session.get(Customer.class, customerId);
			if (customer == null) {
				customer = new Customer();
				customer.setCustomerId(0L);
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

		return customer;

	}

	public List<Customer> getcustomerList() {
		List<Customer> custList = new ArrayList<Customer>();
		System.out.println("Get Entire customer List");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			custList = session.createQuery("FROM Customer").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Entire Customer List " + custList);
		return custList;

	}

	public Response updatecustomer(Customer cust) {
		Response resp = new Response();
		System.out.println("Update Customer ==>" + cust);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			
			if(cust==null)
			{
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Customer with Id = " + cust.getCustomerId());
			}
			
			session.update(cust);
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

	public Response deletecustomer(Long customerId) {
		Response resp = new Response();

		System.out.println("Delete customer");
		System.out.println("Deleting customer  =>" + customerId);

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class,
					customerId);
			if(customer==null)
			{
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Customer with Id = " + customerId);
				return resp;
			}
			customer.setStatus("DELETED");
			session.update(customer);
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
