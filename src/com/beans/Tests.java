package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTS")
public class Tests {

	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", status=" + status + ", testName="
				+ testName + ", shortName=" + shortName + ", lowerValue="
				+ lowerValue + ", upperValue=" + upperValue + ", units="
				+ units + ", testType=" + testType + ", bodyOrgan=" + bodyOrgan
				+ ", description=" + description + ", procedure=" + procedure
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEST_ID", unique = true)
	Long testId;
	@Column(name = "STATUS")
	Integer status;
	@Column(name = "TEST_NAME")
	String testName;
	@Column(name = "SHORT_NAME")
	String shortName;
	@Column(name = "LOWER_VALUE")
	String lowerValue;
	@Column(name = "UPPER_VALUE")
	String upperValue;
	@Column(name = "UNITS")
	String units;
	@Column(name = "TEST_TYPE")
	String testType;
	@Column(name = "BODY_ORGAN")
	String bodyOrgan;
	@Column(name = "DESCRIPTION")
	String description;
	@Column(name = "TEST_STEPS")
	String procedure;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLowerValue() {
		return lowerValue;
	}

	public void setLowerValue(String lowerValue) {
		this.lowerValue = lowerValue;
	}

	public String getUpperValue() {
		return upperValue;
	}

	public void setUpperValue(String upperValue) {
		this.upperValue = upperValue;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getBodyOrgan() {
		return bodyOrgan;
	}

	public void setBodyOrgan(String bodyOrgan) {
		this.bodyOrgan = bodyOrgan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

}
