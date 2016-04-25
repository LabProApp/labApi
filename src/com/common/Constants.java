package com.common;

public class Constants {

	public static final String MORNING = "MORNING";
	public static final String AFTERNOON = "AFTERNOON";
	public static final String EVENING = "EVENING";
	public static final String NIGHT = "NIGHT";
	public static final String PATIENT = "PATIENT";
	public static final String DOCTOR = "PATIENT";
	public static final String LAB_OFFICE = "LAB_OFFICE";
	public static final String LAB_BRANCH = "LAB_BRANCH";
	public static Integer PENDNG_ACTIVATE = 12;
	public static Integer DELETED = 14;
	public static Integer ACTIVE = 11;

	public static String RESP_SUCCESS = "0000";
	public static String RESP_FAIL = "0001";
	public static String RESP_NORECORD = "0002";
	public static String RESP_ALREADYEXISTS = "0003";

	
	//Booking Statuses
	public static Integer PEND_APPROVE = 1;
	public static Integer BOOKED = 2;
	public static Integer CANCELLED_BYPATIENT = 3;
	public static Integer CANCELLED_BYDOCTOR = 4;
	public static Integer VISITIED = 5;
	public static Integer NOT_VISITED = 6;

}
