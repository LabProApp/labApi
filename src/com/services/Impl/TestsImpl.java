package com.services.Impl;

import java.util.ArrayList;
import com.beans.Response;
import com.beans.Tests;

public class TestsImpl {

	public Response add(Tests b) {

		Response resp = new Response();
		System.out.println("Add Test =>" + b);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public Tests get(String TestId) {
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

	public Response updateTest(Tests b) {

		Response resp = new Response();
		System.out.println("Update Test =>" + b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public Response deleteTest(String TestId) {
		Response resp = new Response();

		System.out.println("Delete Test =" + TestId);

		resp.setSTATUS("SUCCESS");
		return resp;

	}
}
