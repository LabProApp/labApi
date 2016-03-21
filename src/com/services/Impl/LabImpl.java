package com.services.Impl;

import java.util.ArrayList;

import com.beans.Response;
import com.beans.lab;


public class LabImpl {
	
	private static LabImpl instance;

	private LabImpl() {

	}

	public static LabImpl getInstance() {
		if (instance == null)
			instance = new LabImpl();
		return instance;
	}
	public Response addLab(lab b) {
		Response resp = new Response();
		System.out.println("Add Lab =>" + b);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	public lab getLab(String labId) {
		lab lr = new lab();
		System.out.println("Fresh Get Lab");
		System.out.println("Lab Id =" + labId);

		if (labId.equalsIgnoreCase("10")) {
			lr.setLabId(labId);
			lr.setLabName("PATIALA LAB");
		}
		if (labId.equalsIgnoreCase("20")) {
			lr.setLabId(labId);
			lr.setLabName("CHANDIGARH LAB");
		}
		System.out.println("Get Lab  =>" + lr);

		return lr;

	}

	public ArrayList<lab> getLabList() {
		ArrayList<lab> labList = new ArrayList<lab>();
		lab lr = new lab();
		System.out.println("Get Entire Lab List");
		lr.setLabId("10");
		lr.setLabName("PATIALA LAB");
		labList.add(lr);
		lab lr2 = new lab();
		lr2.setLabId("20");
		lr2.setLabName("CHANDIGARH LAB");
		labList.add(lr2);

		System.out.println("Get Entire Lab List => " + labList);

		return labList;

	}


	public Response updateLab(lab b) {

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
