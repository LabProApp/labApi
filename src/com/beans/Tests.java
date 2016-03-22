package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "TESTS")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Test")
public class Tests {
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", status=" + status + ", testName="
				+ testName + ", lowerValue=" + lowerValue + ", upperValue="
				+ upperValue + ", units=" + units + ", testType=" + testType
				+ "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "TEST_ID")
	String testId;
	@Column(name = "STATUS")
	String status;
	@Column(name = "NAME")
	String testName;
	@Column(name = "LOWER_VALUE")
	String lowerValue;
	@Column(name = "UPPER_VALUE")
	String upperValue;
	@Column(name = "UNITS")
	String units;
	@Column(name = "TEST_TYPE")
	String testType;
	

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

	

}
