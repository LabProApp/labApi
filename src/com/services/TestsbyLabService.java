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
import com.beans.TestsbyLab;
import com.services.Impl.TestsbyLabImpl;

@Path("/testsbylab")
public class TestsbyLabService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(TestsbyLab tests_lab) {

		System.out.println("Add TestsbyLab =>" + tests_lab);
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		Response resp = testsImpl.add(tests_lab);
		return resp;
	}

	/*@GET
	@Path("/getLabsbyTests")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TestsbyLab> getLabsbyTests(@QueryParam("testsId") Long testsId) {
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		List<TestsbyLab> testList = testsImpl.getLabsbyTests(testsId);
		return testList;

	}

	@GET
	@Path("/getTestsbyLabOffice")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TestsbyLab> getTestsbyLabOffice(
			@QueryParam("labOfficeId") Long labOfficeId) {
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		List<TestsbyLab> testList = testsImpl.getTestsbyLabOffice(labOfficeId);
		return testList;

	}*/

	@GET
	@Path("/getTestsbyLabBranch")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<TestsbyLab> getTestsbyLabBranch(
			@QueryParam("labBranchCd") Long labBranchCd) {
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		 List<TestsbyLab> testList = testsImpl.getTestsbyLabBranch(labBranchCd);
		return testList;

	}

	@POST
	@Path("/updatetestsByLab")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatetestsByLab(TestsbyLab testsbyLab) {

		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		Response resp = testsImpl.updatetestsByLab(testsbyLab);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/deletetestByLab")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletetestByLab(@QueryParam("id") Long id) {

		System.out.println("Delete tests");
		TestsbyLabImpl testsImpl = TestsbyLabImpl.getInstance();
		Response resp = testsImpl.deletetestByLab(id);

		return resp;

	}
}
