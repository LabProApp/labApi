package com.dto;

import com.beans.Address;
import com.beans.LabBranch;
import com.beans.Tests;
import com.beans.TestsbyLab;


public class TestByLabDto {

	LabBranch lb = new LabBranch();
	Address address = new Address();
	TestsbyLab testByLab = new TestsbyLab();
	Tests test = new Tests();

	public LabBranch getLb() {
		return lb;
	}

	
	public void setLb(LabBranch lb) {
		this.lb = lb;
	}

	public Address getAddress() {
		return address;
	}

	
	public void setAddress(Address address) {
		this.address = address;
	}

	public TestsbyLab getTestByLab() {
		return testByLab;
	}

	
	public void setTestByLab(TestsbyLab testByLab) {
		this.testByLab = testByLab;
	}

	public Tests getTest() {
		return test;
	}

	
	public void setTest(Tests test) {
		this.test = test;
	}

}
