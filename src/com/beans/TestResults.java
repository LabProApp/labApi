package com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "TestResults")
public class TestResults {
	@Override
	public String toString() {
		return "TestResults [lb=" + lb + ", cust=" + cust + ", appmnt="
				+ appmnt + ", test=" + test + "]";
	}
	lab lb;
	Customer cust;
	Appointment appmnt;
	Tests test;
	public lab getLb() {
		return lb;
	}
	public void setLb(lab lb) {
		this.lb = lb;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public Appointment getAppmnt() {
		return appmnt;
	}
	public void setAppmnt(Appointment appmnt) {
		this.appmnt = appmnt;
	}
	public Tests getTest() {
		return test;
	}
	public void setTest(Tests test) {
		this.test = test;
	}
	
}
