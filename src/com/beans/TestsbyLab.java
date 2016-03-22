package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TESTS_LAB")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "TestsbyLab")
public class TestsbyLab {

	@Override
	public String toString() {
		return "TestsbyLab [labOfficeId=" + labOfficeId + ", labbranchCode="
				+ labbranchCode + ", testId=" + testId + ", status=" + status
				+ ", isHomePick=" + isHomePick + "]";
	}

	@Column(name = "LAB_OFFICE_ID")
	String labOfficeId;
	@Column(name = "LAB_BRANCH_CD")
	String labbranchCode;
	@Column(name = "TEST_ID")
	String testId;
	@Column(name = "STATUS")
	String status;
	@Column(name = "HOME_PICK")
	boolean isHomePick;

	/**
	 * @return the labOfficeId
	 */
	public String getLabOfficeId() {
		return labOfficeId;
	}

	/**
	 * @param labOfficeId
	 *            the labOfficeId to set
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
	 * @param labbranchCode
	 *            the labbranchCode to set
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
	 * @param testId
	 *            the testId to set
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
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the isHomePick
	 */
	public boolean isHomePick() {
		return isHomePick;
	}

	/**
	 * @param isHomePick
	 *            the isHomePick to set
	 */
	public void setHomePick(boolean isHomePick) {
		this.isHomePick = isHomePick;
	}

}
