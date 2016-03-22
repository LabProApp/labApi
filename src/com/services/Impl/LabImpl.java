package com.services.Impl;

import java.util.ArrayList;

import com.beans.Response;
import com.beans.LabBranch;

public class LabImpl {

	private static LabImpl instance;

	private LabImpl() {

	}

	public static LabImpl getInstance() {
		if (instance == null)
			instance = new LabImpl();
		return instance;
	}

	public Response addLab(LabBranch b) {
		Response resp = new Response();
		System.out.println("Add Lab =>" + b);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public LabBranch getLab(String labId) {
		LabBranch lr = new LabBranch();
		System.out.println("Fresh Get Lab");
		System.out.println("Lab Id =" + labId);

		if (labId.equalsIgnoreCase("10")) {
			lr.setLabOfficeId(labId);
			lr.setLabName("PATIALA LAB");
		}
		if (labId.equalsIgnoreCase("20")) {
			lr.setLabOfficeId(labId);
			lr.setLabName("CHANDIGARH LAB");
		}
		System.out.println("Get Lab  =>" + lr);

		return lr;

	}

	public ArrayList<LabBranch> getLabList() {
		ArrayList<LabBranch> labList = new ArrayList<LabBranch>();
		LabBranch lr = new LabBranch();
		System.out.println("Get Entire Lab List");
		lr.setLabOfficeId("10");
		lr.setLabName("PATIALA LAB");
		labList.add(lr);
		LabBranch lr2 = new LabBranch();
		lr2.setLabOfficeId("20");
		lr2.setLabName("CHANDIGARH LAB");
		labList.add(lr2);

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}

	public Response updateLab(LabBranch b) {

		Response resp = new Response();

		System.out.println("Update Lab => " + b);

		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public Response deleteLab(String labId) {
		Response resp = new Response();
		System.out.println("Delete Lab");
		System.out.println("Lab Id =" + labId);

		resp.setSTATUS("SUCCESS");
		return resp;
	}
}
