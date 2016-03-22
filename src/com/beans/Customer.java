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
@Table(name = "CUSTOMER")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Customer")
public class Customer {
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId="
				+ customerId + ", Age=" + age + ", gender=" + gender
				+ ", status=" + status + ", customerAddress=" + customerAddress
				+ ", primaryMobileNo=" + primaryMobileNo
				+ ", secondaryMobileNo=" + secondaryMobileNo + "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "CUST_ID")
	String customerId;
	@Column(name = "CUST_NAME")
	String customerName;
	@Column(name = "AGE")
	String age;
	@Column(name = "GENDER")
	String gender;
	@Column(name = "STATUS")
	String status;

	@Column(name = "ADDRESS")
	Address customerAddress;
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;
	@Column(name = "SECOND_MOBILE")
	String secondaryMobileNo;

	public String getAge() {

		return age;
	}

	@XmlElement
	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	@XmlElement
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerName() {
		return customerName;
	}

	@XmlElement
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	@XmlElement
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	@XmlElement
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPrimaryMobileNo() {
		return primaryMobileNo;
	}

	@XmlElement
	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}

	public String getSecondaryMobileNo() {
		return secondaryMobileNo;
	}

	@XmlElement
	public void setSecondaryMobileNo(String secondaryMobileNo) {
		this.secondaryMobileNo = secondaryMobileNo;
	}

}
