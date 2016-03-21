package com.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Appointment")
public class Appointment {

	String appntmntId;
	String labId;
	String labbranchCode;
	String custId;
	Tests test;
	Date acceptedOn;
	Date scheduleDate;
	Date testDate;
	boolean isHomePick;
	boolean now;
	String acceptedStatus;

	

}
