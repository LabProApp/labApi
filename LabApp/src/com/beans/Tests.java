package com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Test")
public class Tests {
	@Override
	public String toString() {
		return "Tests [testName=" + testName + ", testId=" + testId
				+ ", status=" + status + ", lowerValue=" + lowerValue
				+ ", upperValue=" + upperValue + ", units=" + units
				+ ", testType=" + testType + ", isHomePick=" + isHomePick + "]";
	}
	String testName, testId, status;
	String lowerValue,upperValue,units;
	String testType;
	boolean isHomePick;
	public String getTestName() {
		return testName;
	}
	@XmlElement
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestId() {
		return testId;
	}
	@XmlElement
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLowerValue() {
		return lowerValue;
	}
	@XmlElement
	public void setLowerValue(String lowerValue) {
		this.lowerValue = lowerValue;
	}
	public String getUpperValue() {
		return upperValue;
	}
	@XmlElement
	public void setUpperValue(String upperValue) {
		this.upperValue = upperValue;
	}
	public String getUnits() {
		return units;
	}
	@XmlElement
	public void setUnits(String units) {
		this.units = units;
	}
	public String getTestType() {
		return testType;
	}
	@XmlElement
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public boolean isHomePick() {
		return isHomePick;
	}
	@XmlElement
	public void setHomePick(boolean isHomePick) {
		this.isHomePick = isHomePick;
	}
	

	
}
