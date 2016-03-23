package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Customer;
import com.beans.Response;
import com.services.Impl.CustomerImpl;

@Path("/customer")
public class CustomerService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response add(Customer cust) {

		System.out.println("Add Customer =>" + cust);
		CustomerImpl customerImpl = CustomerImpl.getInstance();
		Response resp = customerImpl.add(cust);
		return resp;
	}

	@GET
	@Path("/get/{customerId}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer get(@PathParam("customerId") Long customerId) {
		CustomerImpl customerImpl = CustomerImpl.getInstance();
		Customer cust = customerImpl.get(customerId);
		return cust;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getcustomerList() {
		List<Customer> custList;
		CustomerImpl customerImpl = CustomerImpl.getInstance();
		custList = customerImpl.getcustomerList();
		return custList;

	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updatecustomer(Customer cust) {

		CustomerImpl customerImpl = CustomerImpl.getInstance();
		Response resp = customerImpl.updatecustomer(cust);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@DELETE
	@Path("/delete/{customerId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deletecustomer(@PathParam("customerId") Long customerId) {

		System.out.println("Delete customer");
		CustomerImpl customerImpl = CustomerImpl.getInstance();
		Response resp = customerImpl.deletecustomer(customerId);

		return resp;

	}
}
