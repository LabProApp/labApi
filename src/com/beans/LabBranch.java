package com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "LabBranch")
public class LabBranch {

	String labName, labOfficeId, labbranchCode, status, labBranchOwner;
	Address labAddress;
	String labRepresentative1, primaryMobileNo1;
	String labRepresentative2, primaryMobileNo2;
	String labRepresentative3, primaryMobileN3;

	public String getLabName() {
		return labName;
	}

	@XmlElement
	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getLabOfficeId() {
		return labOfficeId;
	}

	@XmlElement
	public void setLabOfficeId(String labOfficeId) {
		this.labOfficeId = labOfficeId;
	}

	

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getLabBranchOwner() {
		return labBranchOwner;
	}

	@XmlElement
	public void setLabBranchOwner(String labBranchOwner) {
		this.labBranchOwner = labBranchOwner;
	}

	public Address getLabAddress() {
		return labAddress;
	}

	@XmlElement
	public void setLabAddress(Address labAddress) {
		this.labAddress = labAddress;
	}

	public String getLabRepresentative1() {
		return labRepresentative1;
	}

	@XmlElement
	public void setLabRepresentative1(String labRepresentative1) {
		this.labRepresentative1 = labRepresentative1;
	}

	public String getPrimaryMobileNo1() {
		return primaryMobileNo1;
	}

	@XmlElement
	public void setPrimaryMobileNo1(String primaryMobileNo1) {
		this.primaryMobileNo1 = primaryMobileNo1;
	}

	public String getLabRepresentative2() {
		return labRepresentative2;
	}

	@XmlElement
	public void setLabRepresentative2(String labRepresentative2) {
		this.labRepresentative2 = labRepresentative2;
	}

	public String getPrimaryMobileNo2() {
		return primaryMobileNo2;
	}

	@XmlElement
	public void setPrimaryMobileNo2(String primaryMobileNo2) {
		this.primaryMobileNo2 = primaryMobileNo2;
	}

	public String getLabRepresentative3() {
		return labRepresentative3;
	}

	@XmlElement
	public void setLabRepresentative3(String labRepresentative3) {
		this.labRepresentative3 = labRepresentative3;
	}

	public String getPrimaryMobileN3() {
		return primaryMobileN3;
	}

	@XmlElement
	public void setPrimaryMobileN3(String primaryMobileN3) {
		this.primaryMobileN3 = primaryMobileN3;
	}

}
