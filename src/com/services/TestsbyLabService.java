package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.TestsbyLab;
import com.services.Impl.TestsbyLabImpl;

@Path("/testsbylab")
public class TestsbyLabService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response add(TestsbyLab tests_lab) {

		System.out.println("Add TestsbyLab =>" + tests_lab);
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		Response resp = testsImpl.add(tests_lab);
		return resp;
	}

	/*@GET
	@Path("/getLabsbyTests/{testsId}")
	@Produces(MediaType.APPLICATION_XML)
	public List<TestsbyLab> getLabsbyTests(@PathParam("testsId") Long testsId) {
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		List<TestsbyLab> testList = testsImpl.getLabsbyTests(testsId);
		return testList;

	}

	@GET
	@Path("/getTestsbyLabOffice/{labOfficeId}")
	@Produces(MediaType.APPLICATION_XML)
	public List<TestsbyLab> getTestsbyLabOffice(
			@PathParam("labOfficeId") Long labOfficeId) {
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		List<TestsbyLab> testList = testsImpl.getTestsbyLabOffice(labOfficeId);
		return testList;

	}*/

	@GET
	@Path("/getTestsbyLabBranch/{labBranchCd}")
	@Produces(MediaType.APPLICATION_XML)
	public  List<TestsbyLab> getTestsbyLabBranch(
			@PathParam("labBranchCd") Long labBranchCd) {
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		 List<TestsbyLab> testList = testsImpl.getTestsbyLabBranch(labBranchCd);
		return testList;

	}

	@POST
	@Path("/updatetestsByLab")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updatetestsByLab(TestsbyLab testsbyLab) {

		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		Response resp = testsImpl.updatetestsByLab(testsbyLab);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/deletetestByLab/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deletetestByLab(@PathParam("id") Long id) {

		System.out.println("Delete tests");
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		Response resp = testsImpl.deletetestByLab(id);

		return resp;

	}
}
