package com.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.beans.Address;
import com.beans.LabBranch;
import com.beans.Tests;
import com.beans.TestsbyLab;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "TestByLabDto")
public class TestByLabDto {

	LabBranch lb = new LabBranch();
	Address address = new Address();
	TestsbyLab testByLab = new TestsbyLab();
	Tests test = new Tests();

	public LabBranch getLb() {
		return lb;
	}

	@XmlElement
	public void setLb(LabBranch lb) {
		this.lb = lb;
	}

	public Address getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(Address address) {
		this.address = address;
	}

	public TestsbyLab getTestByLab() {
		return testByLab;
	}

	@XmlElement
	public void setTestByLab(TestsbyLab testByLab) {
		this.testByLab = testByLab;
	}

	public Tests getTest() {
		return test;
	}

	@XmlElement
	public void setTest(Tests test) {
		this.test = test;
	}

}
