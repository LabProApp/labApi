package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.Tests;
import com.services.Impl.TestsImpl;

@Path("/testresult")
public class TestsResultService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Tests cust) {

		System.out.println("Add Tests =>" + cust);
		TestsImpl testsImpl = TestsImpl.getInstance();
		Response resp = testsImpl.add(cust);
		return resp;
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Tests get(@QueryParam("testsId") Long testsId) {
		TestsImpl testsImpl = TestsImpl.getInstance();
		Tests cust = testsImpl.get(testsId);
		return cust;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tests> gettestsList() {
		List<Tests> testList;
		TestsImpl testsImpl = TestsImpl.getInstance();
		testList = testsImpl.gettestList();
		return testList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatetests(Tests cust) {

		TestsImpl testsImpl = TestsImpl.getInstance();
		Response resp = testsImpl.updatetest(cust);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletetests(@QueryParam("testsId") Long testsId) {

		System.out.println("Delete tests");
		TestsImpl testsImpl = TestsImpl.getInstance();
		Response resp = testsImpl.deletetest(testsId);

		return resp;

	}
}
