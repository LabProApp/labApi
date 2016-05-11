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
@Table(name = "LAB_BRANCH")
public class LabBranch {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "LabBranch [labbranchCode=" + labbranchCode + ", labOfficeId="
				+ labOfficeId + ", labName=" + labName + ", status=" + status
				+ ", labBranchOwner=" + labBranchOwner + ", labAddress="
				+ labAddress + ", primaryMobileNo=" + primaryMobileNo
				+ ", emailID=" + emailID + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LAB_BRANCH_CD", unique = true)
	Long labbranchCode;
	@Column(name = "LAB_OFFICE_ID")
	Long labOfficeId;
	@Column(name = "LAB_NAME")
	String labName;
	@Column(name = "STATUS")
	Integer status;
	@Column(name = "LAB_BR_OWNER")
	String labBranchOwner;
	@OneToOne(cascade = CascadeType.ALL)
	Address labAddress = new Address();
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;

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

	public String getLabBranchOwner() {
		return labBranchOwner;
	}

	/**
	 * @return the labbranchCode
	 */
	public Long getLabbranchCode() {
		return labbranchCode;
	}

	/**
	 * @param labbranchCode
	 *            the labbranchCode to set
	 */

	public void setLabbranchCode(Long labbranchCode) {
		this.labbranchCode = labbranchCode;
	}

	/**
	 * @return the primaryMobileNo3
	 */
	public String getPrimaryMobileNo() {
		return primaryMobileNo;
	}

	/**
	 * @param primaryMobileNo3
	 *            the primaryMobileNo3 to set
	 */

	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}

	public void setLabBranchOwner(String labBranchOwner) {
		this.labBranchOwner = labBranchOwner;
	}

	public Address getLabAddress() {
		return labAddress;
	}

	public void setLabAddress(Address labAddress) {
		this.labAddress = labAddress;
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
