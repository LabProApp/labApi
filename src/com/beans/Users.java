package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USERS")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Users")
public class Users {

	@Override 
	public String toString() {
		return "Users [Id=" + Id + ", emailId=" + emailId + ", mobile="
				+ mobile + ", encPassword=" + encPassword + ", status="
				+ status + ", userTyp=" + userTyp + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true)
	Long Id;
	@Column(name = "EMAIL_ID", unique = true)
	String emailId;
	@Column(name = "MOBILE", unique = true)
	String mobile;
	@Column(name = "ENC_PASSWD")
	String encPassword;
	@Column(name = "STATUS")
	Integer status;
	@Column(name = "USER_TYPE")
	String userTyp; // Doctor/Patient/Laboratory

	public Long getId() {
		return Id;
	}

	@XmlElement
	public void setId(Long id) {
		Id = id;
	}

	
	public String getMobile() {
		return mobile;
	}

	@XmlElement
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEncPassword() {
		return encPassword;
	}

	@XmlElement
	public void setEncPassword(String encPassword) {
		this.encPassword = encPassword;
	}

	public Integer getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserTyp() {
		return userTyp;
	}

	@XmlElement
	public void setUserTyp(String userTyp) {
		this.userTyp = userTyp;
	}

	public String getEmailId() {
		return emailId;
	}
	@XmlElement
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}