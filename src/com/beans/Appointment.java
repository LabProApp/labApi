package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	// Entity to hold Appointment of Patient with Doctor/Lab Branch
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPMNT_ID", unique = true)
	Long appntmntId;
	@Column(name = "APPMNT_REF")
	String appmnt_reference;
	@Column(name = "SCHDLE_ID", unique = true)
	Long scheduleId;
	@Column(name = "DOC_ID")
	Long docId;
	@Column(name = "LAB_BRANCH_CD")
	Long branchCode;
	@Column(name = "PTNT_ID")
	Long ptntId;
	@Column(name = "LAB_REP_ID")
	Long labRepId;
	@Column(name = "HOME_PICK")
	boolean isHomePick;

	@Column(name = "SCHEDULE_DT")
	Date appmntDate;
	@Column(name = "START_TIME")
	Date startTime;
	@Column(name = "END_TIME")
	Date endTime;

	@Column(name = "SHIFT")
	String shift; // morning/afternoon/evening/night. Accordingly time will be
					// calculated based on the token_num
	@Column(name = "TOKEN_NUM")
	Integer token_num;

	@Column(name = "REFF_BY")
	Long refferedByDoc; // Doc Id how reffered this patient

	@Column(name = "DISEASE")
	String diseases_description; // Field to be filled by Patient for
									// problem/disease.
	@Column(name = "PRESCRIPTION")
	String prescription; // Field to be filled by Patient for
							// problem/disease.

	@Column(name = "TEST_IDs")
	String testIds; // || separated Test IDs
	@Column(name = "TEST_RESULT_IDs")
	String testResultIds; // || separated Test Results IDs

	@Column(name = "STATUS")
	Integer status;

	public Long getAppntmntId() {
		return appntmntId;
	}

	@XmlElement
	public void setAppntmntId(Long appntmntId) {
		this.appntmntId = appntmntId;
	}

	public String getAppmnt_reference() {
		return appmnt_reference;
	}

	@XmlElement
	public void setAppmnt_reference(String appmnt_reference) {
		this.appmnt_reference = appmnt_reference;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	@XmlElement
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getAppmntDate() {
		return appmntDate;
	}

	@XmlElement
	public void setAppmntDate(Date appmntDate) {
		this.appmntDate = appmntDate;
	}

	public Long getDocId() {
		return docId;
	}

	@XmlElement
	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getBranchCode() {
		return branchCode;
	}

	@XmlElement
	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}

	public Long getPtntId() {
		return ptntId;
	}

	@XmlElement
	public void setPtntId(Long ptntId) {
		this.ptntId = ptntId;
	}

	public boolean isHomePick() {
		return isHomePick;
	}

	@XmlElement
	public void setHomePick(boolean isHomePick) {
		this.isHomePick = isHomePick;
	}

	public Long getLabRepId() {
		return labRepId;
	}

	@XmlElement
	public void setLabRepId(Long labRepId) {
		this.labRepId = labRepId;
	}

	public Date getStartTime() {
		return startTime;
	}

	@XmlElement
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	@XmlElement
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getShift() {
		return shift;
	}

	@XmlElement
	public void setShift(String shift) {
		this.shift = shift;
	}

	public Integer getToken_num() {
		return token_num;
	}

	@XmlElement
	public void setToken_num(Integer token_num) {
		this.token_num = token_num;
	}

	public Long getRefferedByDoc() {
		return refferedByDoc;
	}

	@XmlElement
	public void setRefferedByDoc(Long refferedByDoc) {
		this.refferedByDoc = refferedByDoc;
	}

	public String getDiseases_description() {
		return diseases_description;
	}

	@XmlElement
	public void setDiseases_description(String diseases_description) {
		this.diseases_description = diseases_description;
	}

	public String getPrescription() {
		return prescription;
	}

	@XmlElement
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getTestIds() {
		return testIds;
	}

	@XmlElement
	public void setTestIds(String testIds) {
		this.testIds = testIds;
	}

	public String getTestResultIds() {
		return testResultIds;
	}

	@XmlElement
	public void setTestResultIds(String testResultIds) {
		this.testResultIds = testResultIds;
	}

}
