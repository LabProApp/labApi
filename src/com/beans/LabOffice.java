package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "LAB_OFFICE")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "LabOffice")
public class LabOffice {

	@Override
	public String toString() {
		return "LabOffice [labName=" + labName + ", labOfficeId=" + labOfficeId
				+ ", status=" + status + ", labAddress=" + labAddress
				+ ", labOwner=" + labOwner + ", labRepresentative="
				+ labRepresentative + ", primaryMobileNo=" + primaryMobileNo
				+ ", secondaryMobileNo=" + secondaryMobileNo + "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "LAB_OFFICE_ID")
	String labOfficeId;
	@Column(name = "LAB_NAME")
	String labName;
	@Column(name = "STATUS")
	String status;
	@Column(name = "ADDRESS")
	Address labAddress;
	@Column(name = "LAB_OWNER")
	String labOwner;
	@Column(name = "LAB_REP")
	String labRepresentative;
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;
	@Column(name = "SECOND_MOBILE")
	String secondaryMobileNo;

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

	
}
