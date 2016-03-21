package com.services.Impl;

import java.util.ArrayList;

import com.beans.Customer;
import com.beans.Response;


public class CustomerImpl {
	
	private static CustomerImpl instance;

	private CustomerImpl() {

	}

	public static CustomerImpl getInstance() {
		if (instance == null)
			instance = new CustomerImpl();
		return instance;
	}
	public Response add(Customer cust) {

		Response resp = new Response();
		System.out.println("Add Customer =>" + cust);
		resp.setSTATUS("SUCCESS");
		return resp;
	}


	public Customer get(String customerId) {
		Customer lr = new Customer();
		System.out.println("Get customer" + customerId);
		if (customerId.equalsIgnoreCase("10")) {
			lr.setCustomerId(customerId);
			lr.setCustomerName("MANINDER");
		}
		if (customerId.equalsIgnoreCase("20")) {
			lr.setCustomerId(customerId);
			lr.setCustomerName("NIKHIL");
		}
		
		return lr;

	}


	public ArrayList<Customer> getcustomerList() {
		ArrayList<Customer> custList = new ArrayList<Customer>();
		System.out.println("Get Entire customer List");

		Customer lr = new Customer();
		lr.setCustomerId("1");
		lr.setCustomerName("Nikhil");

		custList.add(lr);
		Customer lr2 = new Customer();
		lr2.setCustomerId("2");
		lr2.setCustomerName("Maninder");
		custList.add(lr2);
		System.out.println("Entire Customer List " + custList);
		return custList;

	}

	public Response updatecustomer(Customer cust) {
		Response resp = new Response();
		System.out.println("Update Customer ==>" + cust);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public Response deletecustomer(String customerId) {
		Response resp = new Response();

		System.out.println("Delete customer");
		System.out.println("Deleting customer  =>" + customerId);

		resp.setSTATUS("SUCCESS");
		return resp;

	}
}
