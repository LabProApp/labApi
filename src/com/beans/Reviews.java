package com.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Reviews")
public class Reviews {

	/* (non-Javadoc)
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
	String reviewId;
	String doctorId;
	String labOfficeId;
	String branchCode;
	String star_rating;
	Date ratingDate;
	String reviewDescription;
	String ratingCustomerId;
	/**
	 * @return the reviewId
	 */
	public String getReviewId() {
		return reviewId;
	}
	/**
	 * @param reviewId the reviewId to set
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
	 * @param doctorId the doctorId to set
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
	 * @param labOfficeId the labOfficeId to set
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
	 * @param branchCode the branchCode to set
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
	 * @param star_rating the star_rating to set
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
	 * @param ratingDate the ratingDate to set
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
	 * @param reviewDescription the reviewDescription to set
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
	 * @param ratingCustomerId the ratingCustomerId to set
	 */
	public void setRatingCustomerId(String ratingCustomerId) {
		this.ratingCustomerId = ratingCustomerId;
	}

	

}
