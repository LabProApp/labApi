package com.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TEST_RESULTS")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "TestResults")
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

}
