package com.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "DOCTOR")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Doctor")
public class Doctor {


	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", doctorName=" + doctorName
				+ ", branchCode=" + branchCode + ", status=" + status
				+ ", hospitalName=" + hospitalName + ", doctorDegree="
				+ doctorDegrees + ", doctorSpecialization="
				+ doctorSpecialization + ", doctorExperience="
				+ doctorExperience + ", docAddress=" + docAddress
				+ ", primaryMobileNo=" + primaryMobileNo
				+ ", secondaryMobileNo=" + secondaryMobileNo + ", emailID="
				+ emailID + "]";
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID", unique = true)
	
	Long docId;
	@Column(name = "DOC_NAME")
	String doctorName;
	@Column(name = "DOC_BRANCH_CD")
	Long branchCode;
	@Column(name = "STATUS")
	String status;
	@Column(name = "HOSP_NAME")
	String hospitalName;
	@Column(name = "DOC_DEGREE")
	String doctorDegrees;
	@Column(name = "DOC_SPEC")
	String doctorSpecialization;
	@Column(name = "DOC_EXP")
	String doctorExperience;
	@OneToOne(cascade = CascadeType.ALL)
	Address docAddress;
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;
	@Column(name = "SECOND_MOBILE")
	String secondaryMobileNo;
	@Column(name = "EMAIL_ID")
	String emailID;
	
	public String getDoctorName() {
		return doctorName;
	}

	@XmlElement
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getDocId() {
		return docId;
	}

	@XmlElement
	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getBranchCode() {
		return branchCode;
	}

	@XmlElement
	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	@XmlElement
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDoctorDegrees() {
		return doctorDegrees;
	}

	@XmlElement
	public void setDoctorDegrees(String doctorDegree) {
		this.doctorDegrees = doctorDegree;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	@XmlElement
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public String getDoctorExperience() {
		return doctorExperience;
	}

	@XmlElement
	public void setDoctorExperience(String doctorExperience) {
		this.doctorExperience = doctorExperience;
	}

	public Address getDocAddress() {
		return docAddress;
	}

	@XmlElement
	public void setDocAddress(Address docAddress) {
		this.docAddress = docAddress;
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

	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID the emailID to set
	 */
	@XmlElement
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
