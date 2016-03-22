package com.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

public class Doctor {
	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", docId=" + docId
				+ ", branchCode=" + branchCode + ", status=" + status
				+ ", hospitalName=" + hospitalName + ", doctorDegree="
				+ doctorDegree + ", doctorSpecialization="
				+ doctorSpecialization + ", doctorExperience="
				+ doctorExperience + ", docAddress=" + docAddress
				+ ", doctorPRO=" + doctorPRO + ", primaryMobileNo="
				+ primaryMobileNo + ", secondaryMobileNo=" + secondaryMobileNo
				+ "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "DOC_ID")
	String docId;
	@Column(name = "NAME")
	String doctorName;
	@Column(name = "DOC_BRANCH_CD")
	String branchCode;
	@Column(name = "STATUS")
	String status;
	@Column(name = "HOSP_NAME")
	String hospitalName;
	@Column(name = "DOC_DEGREE")
	ArrayList<String> doctorDegree;
	@Column(name = "DOC_SPEC")
	ArrayList<String> doctorSpecialization;
	@Column(name = "DOC_EXP")
	ArrayList<String> doctorExperience;

	Address docAddress;
	String doctorPRO, primaryMobileNo, secondaryMobileNo;

	public String getDoctorName() {
		return doctorName;
	}

	@XmlElement
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDocId() {
		return docId;
	}

	@XmlElement
	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	@XmlElement
	public void setBranchCode(String branchCode) {
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

	public ArrayList<String> getDoctorDegree() {
		return doctorDegree;
	}

	@XmlElement
	public void setDoctorDegree(ArrayList<String> doctorDegree) {
		this.doctorDegree = doctorDegree;
	}

	public ArrayList<String> getDoctorSpecialization() {
		return doctorSpecialization;
	}

	@XmlElement
	public void setDoctorSpecialization(ArrayList<String> doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public ArrayList<String> getDoctorExperience() {
		return doctorExperience;
	}

	@XmlElement
	public void setDoctorExperience(ArrayList<String> doctorExperience) {
		this.doctorExperience = doctorExperience;
	}

	public Address getDocAddress() {
		return docAddress;
	}

	@XmlElement
	public void setDocAddress(Address docAddress) {
		this.docAddress = docAddress;
	}

	public String getDoctorPRO() {
		return doctorPRO;
	}

	@XmlElement
	public void setDoctorPRO(String doctorPRO) {
		this.doctorPRO = doctorPRO;
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
