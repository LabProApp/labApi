package com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "LabOffice")
public class LabOffice {

	String labName, labOfficeId, status;
	Address labAddress;
	String labOwner, labRepresentative, primaryMobileNo, secondaryMobileNo;

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

	public Address getLabAddress() {
		return labAddress;
	}

	@XmlElement
	public void setLabAddress(Address labAddress) {
		this.labAddress = labAddress;
	}

	public String getLabOwner() {
		return labOwner;
	}

	@XmlElement
	public void setLabOwner(String labOwner) {
		this.labOwner = labOwner;
	}

	public String getLabRepresentative() {
		return labRepresentative;
	}

	@XmlElement
	public void setLabRepresentative(String labRepresentative) {
		this.labRepresentative = labRepresentative;
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

	@Override
	public String toString() {
		return "LabOffice [labName=" + labName + ", labOfficeId=" + labOfficeId
				+ ", status=" + status + ", labAddress=" + labAddress
				+ ", labOwner=" + labOwner + ", labRepresentative="
				+ labRepresentative + ", primaryMobileNo=" + primaryMobileNo
				+ ", secondaryMobileNo=" + secondaryMobileNo + "]";
	}

}
