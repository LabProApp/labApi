package com.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Appointment")
public class Appointment {

	

	String appntmntId;
	String labOfficeId;
	String branchCode;
	String customerId;
	String testId;
	String resultsId;
	Date acceptedOn;
	Date scheduleDate;
	Date testDate;
	boolean isHomePick;
	boolean now;
	String status;
	String refferedBy;
	Date refferedOn;

	public String getAppntmntId() {
		return appntmntId;
	}

	@XmlElement
	public void setAppntmntId(String appntmntId) {
		this.appntmntId = appntmntId;
	}

	

	
	public String getTestId() {
		return testId;
	}

	@XmlElement
	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Date getAcceptedOn() {
		return acceptedOn;
	}

	@XmlElement
	public void setAcceptedOn(Date acceptedOn) {
		this.acceptedOn = acceptedOn;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	@XmlElement
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Date getTestDate() {
		return testDate;
	}

	@XmlElement
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public boolean isHomePick() {
		return isHomePick;
	}

	@XmlElement
	public void setHomePick(boolean isHomePick) {
		this.isHomePick = isHomePick;
	}

	public boolean isNow() {
		return now;
	}

	@XmlElement
	public void setNow(boolean now) {
		this.now = now;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefferedBy() {
		return refferedBy;
	}

	@XmlElement
	public void setRefferedBy(String refferedBy) {
		this.refferedBy = refferedBy;
	}

	public Date getRefferedOn() {
		return refferedOn;
	}

	@XmlElement
	public void setRefferedOn(Date refferedOn) {
		this.refferedOn = refferedOn;
	}

}
