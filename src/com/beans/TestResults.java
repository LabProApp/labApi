package com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "TestResults")
public class TestResults {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestResults [resultsId=" + resultsId + ", labId=" + labId
				+ ", custId=" + custId + ", appmntId=" + appmntId + ", testId="
				+ testId + ", resultvalue=" + resultvalue
				+ ", resultDescription=" + resultDescription
				+ ", labrecommendation=" + labRecommendation + ", status="
				+ status + ", refferedByDoctorId=" + refferedByDoctorId
				+ ", doctorrecommendation=" + doctorRecommendation + "]";
	}
	String resultsId;
	String labId;
	String custId;
	String appmntId;
	String testId;
	String resultvalue;
	String resultDescription;
	String labRecommendation;
	String status;
	String refferedByDoctorId;
	String doctorRecommendation;
	/**
	 * @return the resultsId
	 */
	public String getResultsId() {
		return resultsId;
	}
	/**
	 * @param resultsId the resultsId to set
	 */
	@XmlElement
	public void setResultsId(String resultsId) {
		this.resultsId = resultsId;
	}
	/**
	 * @return the labId
	 */
	public String getLabId() {
		return labId;
	}
	/**
	 * @param labId the labId to set
	 */
	@XmlElement
	public void setLabId(String labId) {
		this.labId = labId;
	}
	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * @param custId the custId to set
	 */
	@XmlElement
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * @return the appmntId
	 */
	public String getAppmntId() {
		return appmntId;
	}
	/**
	 * @param appmntId the appmntId to set
	 */
	@XmlElement
	public void setAppmntId(String appmntId) {
		this.appmntId = appmntId;
	}
	/**
	 * @return the testId
	 */
	public String getTestId() {
		return testId;
	}
	/**
	 * @param testId the testId to set
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
	 * @param resultvalue the resultvalue to set
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
	 * @param resultDescription the resultDescription to set
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
	 * @param labrecommendation the labrecommendation to set
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
	 * @param status the status to set
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
	 * @param refferedByDoctorId the refferedByDoctorId to set
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
	 * @param doctorrecommendation the doctorrecommendation to set
	 */
	@XmlElement
	public void setDoctorRecommendation(String doctorrecommendation) {
		this.doctorRecommendation = doctorrecommendation;
	}

}
