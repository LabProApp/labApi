package com.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.Tests;

@Path("/test")
public class TestsService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response add(Tests b) {

		Response resp = new Response();
		System.out.println("Add Test =>" + b);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@GET
	@Path("/get/{TestId}")
	@Produces(MediaType.APPLICATION_XML)
	public Tests get(@PathParam("TestId") String TestId) {
		Tests lr = new Tests();
		System.out.println("Get Test");

		if (TestId.equalsIgnoreCase("10")) {
			lr.setTestId(TestId);
			lr.setTestName("MANINDER");
		}
		if (TestId.equalsIgnoreCase("20")) {
			lr.setTestId(TestId);
			lr.setTestName("NIKHIL");
		}
		lr.setStatus("SUCCESS");
		System.out.println("Test  =" + lr);
		return lr;

	}

	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Tests> getTestList() {
		ArrayList<Tests> testsList = new ArrayList<Tests>();
		System.out.println("Get Entire Test List");
		Tests lr = new Tests();

		Tests lr2 = new Tests();
		System.out.println("Get Test List");

		lr.setTestId("1");
		lr.setTestName("MANINDER");
		testsList.add(lr);

		lr2.setTestId("2");
		lr.setTestName("NIKHIL");
		testsList.add(lr2);
		System.out.println("Tests List => " + testsList);
		return testsList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateTest(Tests b) {

		Response resp = new Response();
		System.out.println("Update Test =>" + b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete/{TestId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteTest(@PathParam("TestId") String TestId) {
		Response resp = new Response();

		
		System.out.println("Delete Test =" + TestId);

		resp.setSTATUS("SUCCESS");
		return resp;

	}
}
