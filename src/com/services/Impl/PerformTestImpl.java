package com.services.Impl;

import javax.persistence.EntityManager;

import com.beans.Appointment;
import com.beans.Response;
import com.dao.EmManager;

public class PerformTestImpl {

	private static EntityManager em;

	public static PerformTestImpl instance;

	private PerformTestImpl() {

	}

	public static PerformTestImpl getInstance() {
		if (instance == null) {
			instance = new PerformTestImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}


	public Response getReports(Appointment appmnt) {
		Response resp = new Response();

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public Response updateStatus(Appointment appmnt) {
		Response resp = new Response();

		// TODO
		// Update AppmntStatus = TEST_EXECUTED/SAMPLE_COLLECTED/

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public Response uploadReports(String appntId) {

		Response resp = new Response();
		// TODO
		// Update AppmntStatus = REPORTS_UPLOADED
		// Upload Reports in BLOB
		resp.setSTATUS("SUCCESS");
		return resp;

	}

}
