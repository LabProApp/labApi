package com.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.beans.Address;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "LabBranchDto")
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

	@XmlElement
	public void setLabName(String labName) {
		this.labName = labName;
	}

	public Long getLabOfficeId() {
		return labOfficeId;
	}

	@XmlElement
	public void setLabOfficeId(Long labOfficeId) {
		this.labOfficeId = labOfficeId;
	}

	public Integer getStatus() {
		return status;
	}

	@XmlElement
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
	@XmlElement
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
	@XmlElement
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getImg_path() {
		return img_path;
	}

	@XmlElement
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public Address getLabAddress() {
		return labAddress;
	}

	@XmlElement
	public void setLabAddress(Address labAddress) {
		this.labAddress = labAddress;
	}

	@XmlElement
	public void setLabBranchOwner(String labBranchOwner) {
		this.labBranchOwner = labBranchOwner;
	}

	@XmlElement
	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}

}
