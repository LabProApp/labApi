package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "REVIEWS")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Reviews")
public class Reviews {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", doctorId=" + doctorId
				+ ", labOfficeId=" + labOfficeId + ", branchCode=" + branchCode
				+ ", star_rating=" + star_rating + ", ratingDate=" + ratingDate
				+ ", reviewDescription=" + reviewDescription
				+ ", ratingCustomerId=" + ratingCustomerId + "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "REVIEW_ID")
	String reviewId;
	@Column(name = "PTNT_ID")
	String ratingCustomerId;
	@Column(name = "DOCTOR_ID")
	String doctorId;
	@Column(name = "LAB_OFFICE_ID")
	String labOfficeId;
	@Column(name = "LAB_BRANCH_CD")
	String branchCode;
	@Column(name = "RATING")
	String star_rating;
	@Column(name = "RATING_DT")
	Date ratingDate;
	@Column(name = "REVIEW")
	String reviewDescription;

	/**
	 * @return the reviewId
	 */
	public String getReviewId() {
		return reviewId;
	}

	/**
	 * @param reviewId
	 *            the reviewId to set
	 */
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * @return the doctorId
	 */
	public String getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId
	 *            the doctorId to set
	 */
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the labOfficeId
	 */
	public String getLabOfficeId() {
		return labOfficeId;
	}

	/**
	 * @param labOfficeId
	 *            the labOfficeId to set
	 */
	public void setLabOfficeId(String labOfficeId) {
		this.labOfficeId = labOfficeId;
	}

	/**
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode
	 *            the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the star_rating
	 */
	public String getStar_rating() {
		return star_rating;
	}

	/**
	 * @param star_rating
	 *            the star_rating to set
	 */
	public void setStar_rating(String star_rating) {
		this.star_rating = star_rating;
	}

	/**
	 * @return the ratingDate
	 */
	public Date getRatingDate() {
		return ratingDate;
	}

	/**
	 * @param ratingDate
	 *            the ratingDate to set
	 */
	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}

	/**
	 * @return the reviewDescription
	 */
	public String getReviewDescription() {
		return reviewDescription;
	}

	/**
	 * @param reviewDescription
	 *            the reviewDescription to set
	 */
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	/**
	 * @return the ratingCustomerId
	 */
	public String getRatingCustomerId() {
		return ratingCustomerId;
	}

	/**
	 * @param ratingCustomerId
	 *            the ratingCustomerId to set
	 */
	public void setRatingCustomerId(String ratingCustomerId) {
		this.ratingCustomerId = ratingCustomerId;
	}

}
