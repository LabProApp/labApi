package com.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LAB_OFFICE")

public class LabOffice {

	@Override
	public String toString() {
		return "LabOffice [labOfficeId=" + labOfficeId + ", labName=" + labName
				+ ", status=" + status + ", labAddress=" + labAddress
				+ ", labOwner=" + labOwner + ", primaryMobileNo="
				+ primaryMobileNo + ", secondaryMobileNo=" + secondaryMobileNo
				+ ", emailID=" + emailID + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LAB_OFFICE_ID", unique = true)
	Long labOfficeId;
	@Column(name = "LAB_NAME")
	String labName;
	@Column(name = "STATUS")
	Integer status;
	@OneToOne(cascade = CascadeType.ALL)
	Address labAddress = new Address();
	@Column(name = "LAB_OWNER")
	String labOwner;

	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo; 
	@Column(name = "SECOND_MOBILE")
	String secondaryMobileNo;
	@Column(name = "EMAIL_ID")
	String emailID;
	
	public String getLabName() {
		return labName;
	}

	
	public void setLabName(String labName) {
		this.labName = labName;
	}

	public Long getLabOfficeId() {
		return labOfficeId;
	}

	
	public void setLabOfficeId(Long labOfficeId) {
		this.labOfficeId = labOfficeId;
	}

	public Integer getStatus() {
		return status;
	}

	
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Address getLabAddress() {
		return labAddress;
	}

	
	public void setLabAddress(Address labAddress) {
		this.labAddress = labAddress;
	}

	public String getLabOwner() {
		return labOwner;
	}

	
	public void setLabOwner(String labOwner) {
		this.labOwner = labOwner;
	}

	public String getPrimaryMobileNo() {
		return primaryMobileNo;
	}

	
	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}

	public String getSecondaryMobileNo() {
		return secondaryMobileNo;
	}

	
	public void setSecondaryMobileNo(String secondaryMobileNo) {
		this.secondaryMobileNo = secondaryMobileNo;
	}

	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID
	 *            the emailID to set
	 */
	
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	
}
