package com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "TestsbyLab")
public class TestsbyLab {

	String labOfficeId,labbranchCode,testId, status;
	
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
	 * @return the labbranchCode
	 */
	public String getLabbranchCode() {
		return labbranchCode;
	}

	/**
	 * @param labbranchCode the labbranchCode to set
	 */
	public void setLabbranchCode(String labbranchCode) {
		this.labbranchCode = labbranchCode;
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
	public void setTestId(String testId) {
		this.testId = testId;
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
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	

	
}
