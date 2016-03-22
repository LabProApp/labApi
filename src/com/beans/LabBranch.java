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
@Table(name = "LAB_BRANCH")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "LabBranch")
public class LabBranch {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LabBranch [labOfficeId=" + labOfficeId + ", labName=" + labName
				+ ", labbranchCode=" + labbranchCode + ", status=" + status
				+ ", labBranchOwner=" + labBranchOwner + ", labAddress="
				+ labAddress + ", labRepresentative1=" + labRepresentative1
				+ ", primaryMobileNo1=" + primaryMobileNo1
				+ ", labRepresentative2=" + labRepresentative2
				+ ", primaryMobileNo2=" + primaryMobileNo2
				+ ", labRepresentative3=" + labRepresentative3
				+ ", primaryMobileNo3=" + primaryMobileNo3 + "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "LAB_OFFICE_ID")
	String labOfficeId;
	@Column(name = "NAME")
	String labName;
	@Column(name = "LAB_BRANCH_CD")
	String labbranchCode;
	@Column(name = "STATUS")
	String status;
	@Column(name = "LAB_BR_OWNER")
	String labBranchOwner;
	@Column(name = "ADDRESS")
	Address labAddress;
	@Column(name = "LAB_REP1")
	String labRepresentative1;
	@Column(name = "PRIM_MOBILE1")
	String primaryMobileNo1;
	@Column(name = "LAB_REP2")
	String labRepresentative2;
	@Column(name = "PRIM_MOBILE2")
	String primaryMobileNo2;
	@Column(name = "LAB_REP3")
	String labRepresentative3;
	@Column(name = "PRIM_MOBILE3")
	String primaryMobileNo3;

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
		return primaryMobileNo3;
	}

	@XmlElement
	public void setPrimaryMobileN3(String primaryMobileNo3) {
		this.primaryMobileNo3 = primaryMobileNo3;
	}

}
