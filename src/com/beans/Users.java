package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {

	@Override
	public String toString() {
		return "Users [Id=" + Id + ", name=" + name + ", emailId=" + emailId
				+ ", mobile=" + mobile + ", encPassword=" + encPassword
				+ ", status=" + status + ", userTyp=" + userTyp + ", otp="
				+ otp + ", otpSentTime=" + otpSentTime + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true)
	Long Id;
	@Column(name = "NAME")
	String name;
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
	@Column(name = "OTP")
	String otp;
	@Column(name = "OTP_TIME")
	Date otpSentTime;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEncPassword() {
		return encPassword;
	}

	public void setEncPassword(String encPassword) {
		this.encPassword = encPassword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserTyp() {
		return userTyp;
	}

	public void setUserTyp(String userTyp) {
		this.userTyp = userTyp;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Date getOtpSentTime() {
		return otpSentTime;
	}

	public void setOtpSentTime(Date otpSentTime) {
		this.otpSentTime = otpSentTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
