package com.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CUST_ID", unique = true)
	Long customerId;
	@Column(name = "CUST_NAME")
	String customerName;
	@Column(name = "AGE")
	Integer age;
	@Column(name = "GENDER")
	String gender;
	@Column(name = "STATUS")
	String status;

	@Column(name = "ADDRESS_ID")
	String customerAddress;
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;
	@Column(name = "SECOND_MOBILE")
	String secondaryMobileNo;

	public Integer getAge() {

		return age;
	}

	@XmlElement
	public void setAge(Integer age) {
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

	public Long getCustomerId() {
		return customerId;
	}

	@XmlElement
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	@XmlElement
	public void setCustomerAddress(String customerAddress) {
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
