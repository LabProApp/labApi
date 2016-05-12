package com.dto;

import com.beans.Address;


public class LabBranchDto {

	Long labbranchCode;

	Long labOfficeId;

	String labName;

	Integer status;

	String labBranchOwner;

	Address labAddress= new Address();

	String primaryMobileNo;

	String emailID;

	String img_path;

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

	public String getImg_path() {
		return img_path;
	}

	
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public Address getLabAddress() {
		return labAddress;
	}

	
	public void setLabAddress(Address labAddress) {
		this.labAddress = labAddress;
	}

	
	public void setLabBranchOwner(String labBranchOwner) {
		this.labBranchOwner = labBranchOwner;
	}

	
	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}

}
