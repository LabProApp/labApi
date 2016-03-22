package com.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Reviews")
public class Reviews {

	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", labId=" + labId
				+ ", labbranchCode=" + labbranchCode + ", star_rating="
				+ star_rating + ", ratingDate=" + ratingDate
				+ ", reviewDescription=" + reviewDescription
				+ ", ratingCustomerId=" + ratingCustomerId + "]";
	}

	String reviewId;
	String labId;
	String labbranchCode;
	String star_rating;
	Date ratingDate;
	String reviewDescription;
	String ratingCustomerId;

	public String getLabId() {
		return labId;
	}

	@XmlElement
	public void setLabId(String labId) {
		this.labId = labId;
	}

	public String getLabbranchCode() {
		return labbranchCode;
	}

	@XmlElement
	public void setLabbranchCode(String labbranchCode) {
		this.labbranchCode = labbranchCode;
	}

	public String getReviewId() {
		return reviewId;
	}

	@XmlElement
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getStar_rating() {
		return star_rating;
	}

	@XmlElement
	public void setStar_rating(String star_rating) {
		this.star_rating = star_rating;
	}

	public Date getRatingDate() {
		return ratingDate;
	}

	@XmlElement
	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	@XmlElement
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	public String getRatingCustomerId() {
		return ratingCustomerId;
	}

	@XmlElement
	public void setRatingCustomerId(String ratingCustomerId) {
		this.ratingCustomerId = ratingCustomerId;
	}

}
