package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@Entity
@Table(name = "APPOINTMENT")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Appointment")
public class Appointment {

	Long appntmntId;
	@Column(name = "LAB_OFFICE_ID")
	Long labOfficeId;
	@Column(name = "LAB_BRANCH_CD")
	Long branchCode;
	@Column(name = "CUST_ID")
	Long customerId;
	@Column(name = "TEST_ID")
	Long testId;
	@Column(name = "TEST_RESULTS_ID")
	Long resultsId;
	@Column(name = "ACCEPTED_DT")
	Date acceptedOn;
	@Column(name = "SCHEDULE_DT")
	Date scheduleDate;
	@Column(name = "TEST_DT")
	Date testDate;
	@Column(name = "HOME_PICK")
	boolean isHomePick;
	@Column(name = "NOW")
	boolean now;
	@Column(name = "STATUS")
	String status;
	@Column(name = "DOC_ID")
	Long refferedBy;
	@Column(name = "REFFERED_DT")
	Date refferedOn;

	public Long getAppntmntId() {
		return appntmntId;
	}

	@XmlElement
	public void setAppntmntId(Long appntmntId) {
		this.appntmntId = appntmntId;
	}

	public Long getTestId() {
		return testId;
	}

	@XmlElement
	public void setTestId(Long testId) {
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

	public Long getRefferedBy() {
		return refferedBy;
	}

	@XmlElement
	public void setRefferedBy(Long refferedBy) {
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
