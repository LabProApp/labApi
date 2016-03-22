package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TEST_RESULTS")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "TestResults")
public class TestResults {

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestResults [resultsId=" + resultsId + ", labOfficeId="
				+ labOfficeId + ", customerId=" + customerId + ", appntmntId="
				+ appntmntId + ", testId=" + testId + ", status=" + status
				+ ", resultvalue=" + resultvalue + ", resultDescription="
				+ resultDescription + ", labRecommendation="
				+ labRecommendation + ", refferedByDoctorId="
				+ refferedByDoctorId + ", doctorRecommendation="
				+ doctorRecommendation + "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "TEST_RESULTS_ID")
	String resultsId;
	@Column(name = "LAB_OFFICE_ID")
	String labOfficeId;
	@Column(name = "CUST_ID")
	String customerId;
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

	/**
	 * @return the resultsId
	 */
	public String getResultsId() {
		return resultsId;
	}

	/**
	 * @param resultsId
	 *            the resultsId to set
	 */
	@XmlElement
	public void setResultsId(String resultsId) {
		this.resultsId = resultsId;
	}

	

	/**
	 * @param custId
	 *            the custId to set
	 */
	
	/**
	 * @return the testId
	 */
	public String getTestId() {
		return testId;
	}

	/**
	 * @param testId
	 *            the testId to set
	 */
	@XmlElement
	public void setTestId(String testId) {
		this.testId = testId;
	}

	/**
	 * @return the resultvalue
	 */
	public String getResultvalue() {
		return resultvalue;
	}

	/**
	 * @param resultvalue
	 *            the resultvalue to set
	 */
	@XmlElement
	public void setResultvalue(String resultvalue) {
		this.resultvalue = resultvalue;
	}

	/**
	 * @return the resultDescription
	 */
	public String getResultDescription() {
		return resultDescription;
	}

	/**
	 * @param resultDescription
	 *            the resultDescription to set
	 */
	@XmlElement
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	/**
	 * @return the labrecommendation
	 */
	public String getLabRecommendation() {
		return labRecommendation;
	}

	/**
	 * @param labrecommendation
	 *            the labrecommendation to set
	 */
	@XmlElement
	public void setLabRecommendation(String labrecommendation) {
		this.labRecommendation = labrecommendation;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the refferedByDoctorId
	 */
	public String getRefferedByDoctorId() {
		return refferedByDoctorId;
	}

	/**
	 * @param refferedByDoctorId
	 *            the refferedByDoctorId to set
	 */
	@XmlElement
	public void setRefferedByDoctorId(String refferedByDoctorId) {
		this.refferedByDoctorId = refferedByDoctorId;
	}

	/**
	 * @return the doctorrecommendation
	 */
	public String getDoctorRecommendation() {
		return doctorRecommendation;
	}

	/**
	 * @param doctorrecommendation
	 *            the doctorrecommendation to set
	 */
	@XmlElement
	public void setDoctorRecommendation(String doctorrecommendation) {
		this.doctorRecommendation = doctorrecommendation;
	}

	/**
	 * @return the labOfficeId
	 */
	public String getLabOfficeId() {
		return labOfficeId;
	}

	/**
	 * @param labOfficeId the labOfficeId to set
	 */
	public void setLabOfficeId(String labOfficeId) {
		this.labOfficeId = labOfficeId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the appntmntId
	 */
	public String getAppntmntId() {
		return appntmntId;
	}

	/**
	 * @param appntmntId the appntmntId to set
	 */
	public void setAppntmntId(String appntmntId) {
		this.appntmntId = appntmntId;
	}

}
