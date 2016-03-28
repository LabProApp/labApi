package com.beans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "APPOINTMENT")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Appointment")
public class Appointment {

	
	//Entity to hold Appointment of Pateint with Doctor/Lab Branch 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPMNT_ID", unique = true)
	Long appntmntId;
	@Column(name = "SCHDLE_ID", unique = true)
	Long scheduleId;
	@Column(name = "DOC_ID")
	Long docId;
	@Column(name = "LAB_OFFICE_ID")
	Long labOfficeId;
	@Column(name = "LAB_BRANCH_CD")
	Long branchCode;
	@Column(name = "PTNT_ID")
	Long ptntId;
	@Column(name = "ACCEPTED_DT")
	Date acceptedOn;
	@Column(name = "SCHEDULE_DT")
	Date scheduleDate;
	@Column(name = "HOME_PICK")
	boolean isHomePick;
	@Column(name = "NOW")
	boolean now;
	@Column(name = "START_TIME")
	Time startTime;
	@Column(name = "END_TIME")
	Time endTime;
	@Column(name = "STATUS")  // If Status is Booking_Cancelled then assign the same appointment to another patient.
							// and make TEST_IDs & TEST_RESULTS_ID NULL
	String status;
	@Column(name = "REFF_BY")
	Long refferedByDoc; // Doc Id how reffered this patient
	@Column(name = "REFFERED_DT")
	Date refferedOn;
	@Column(name = "DISEASE")
	String diseases_description; // Field to be filled by Patient for
									// problem/disease.
	@Column(name = "WHEN")
	String when;  // morning/afternoon/evening/night. Accordingly time will be calculated 
	
	@Column(name = "TOKEN_NUM")
	Integer tooken_num;
	@Column(name = "TEST_IDs")
	ArrayList<Long> testIds;
	@Column(name = "TEST_RESULTS_ID")
	ArrayList<Long> testResultsIds;
	public Long getAppntmntId() {
		return appntmntId;
	}
	public void setAppntmntId(Long appntmntId) {
		this.appntmntId = appntmntId;
	}
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Long getDocId() {
		return docId;
	}
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	public Long getLabOfficeId() {
		return labOfficeId;
	}
	public void setLabOfficeId(Long labOfficeId) {
		this.labOfficeId = labOfficeId;
	}
	public Long getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}
	public Long getPtntId() {
		return ptntId;
	}
	public void setPtntId(Long ptntId) {
		this.ptntId = ptntId;
	}
	public Date getAcceptedOn() {
		return acceptedOn;
	}
	public void setAcceptedOn(Date acceptedOn) {
		this.acceptedOn = acceptedOn;
	}
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public boolean isHomePick() {
		return isHomePick;
	}
	public void setHomePick(boolean isHomePick) {
		this.isHomePick = isHomePick;
	}
	public boolean isNow() {
		return now;
	}
	public void setNow(boolean now) {
		this.now = now;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getRefferedByDoc() {
		return refferedByDoc;
	}
	public void setRefferedByDoc(Long refferedByDoc) {
		this.refferedByDoc = refferedByDoc;
	}
	public Date getRefferedOn() {
		return refferedOn;
	}
	public void setRefferedOn(Date refferedOn) {
		this.refferedOn = refferedOn;
	}
	public String getDiseases_description() {
		return diseases_description;
	}
	public void setDiseases_description(String diseases_description) {
		this.diseases_description = diseases_description;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public Integer getTooken_num() {
		return tooken_num;
	}
	public void setTooken_num(Integer tooken_num) {
		this.tooken_num = tooken_num;
	}
	public ArrayList<Long> getTestIds() {
		return testIds;
	}
	public void setTestIds(ArrayList<Long> testIds) {
		this.testIds = testIds;
	}
	public ArrayList<Long> getTestResultsIds() {
		return testResultsIds;
	}
	public void setTestResultsIds(ArrayList<Long> testResultsIds) {
		this.testResultsIds = testResultsIds;
	}
	

}
