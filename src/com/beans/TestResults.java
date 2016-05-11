package com.beans;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TEST_RESULTS")
public class TestResults {

	@Id
	@GeneratedValue
	@Column(name = "TEST_RESULTS_ID")
	String testResultsId;
	@Column(name = "APPMNT_ID")
	String appntmntId;
	@Column(name = "TEST_ID")
	String testId;
	@Column(name = "STATUS")
	String status;
	@Column(name = "RESULT_VALUE")
	String resultvalue;
	@Column(name = "RESULT_DESC")
	String resultDescription;
	@Column(name = "LAB_RECOMM")
	String labRecommendation;
	@Column(name = "REF_DOC_ID")
	String refferedByDoctorId;
	@Column(name = "DOC_RECOMM")
	String doctorRecommendation;
	@Column(name = "REPORT_FILE")
	Blob report;
	@Column(name = "FILE_FORMAT")
	String fileFormat;
	@Transient
	String testDatestr;
	@Column(name = "TEST_DATE")
	Date testDate;

	public String getTestResultsId() {
		return testResultsId;
	}

	public void setTestResultsId(String testResultsId) {
		this.testResultsId = testResultsId;
	}

	public String getAppntmntId() {
		return appntmntId;
	}

	public void setAppntmntId(String appntmntId) {
		this.appntmntId = appntmntId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResultvalue() {
		return resultvalue;
	}

	public void setResultvalue(String resultvalue) {
		this.resultvalue = resultvalue;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public String getLabRecommendation() {
		return labRecommendation;
	}

	public void setLabRecommendation(String labRecommendation) {
		this.labRecommendation = labRecommendation;
	}

	public String getRefferedByDoctorId() {
		return refferedByDoctorId;
	}

	public void setRefferedByDoctorId(String refferedByDoctorId) {
		this.refferedByDoctorId = refferedByDoctorId;
	}

	public String getDoctorRecommendation() {
		return doctorRecommendation;
	}

	public void setDoctorRecommendation(String doctorRecommendation) {
		this.doctorRecommendation = doctorRecommendation;
	}

	public Blob getReport() {
		return report;
	}

	public void setReport(Blob report) {
		this.report = report;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getTestDatestr() {
		return testDatestr;
	}

	public void setTestDatestr(String testDatestr) {
		this.testDatestr = testDatestr;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

}
