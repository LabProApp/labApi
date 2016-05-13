package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "IMAGES")
public class Images {

	@Override
	public String toString() {
		return "Images [entityId=" + entityId + ", entityTyp=" + entityTyp
				+ ", imgname=" + imgname + ", s3Path=" + s3Path + ", imgTyp="
				+ imgTyp + ", imgUrl=" + imgUrl + "]";
	}

	@Id
	@Column(name = "IMAGES_ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long imageId;
	@Column(name = "ENTITY_ID")
	Long entityId;
	@Column(name = "ENTITY_TYP")
	String entityTyp; // Doctor/Patient/Laboratory
	@Column(name = "IMG_NAME")
	String imgname; // image name or memo
	@Column(name = "IMG_TYPE")
	String imgTyp;
	@Column(name = "S3_PATH")
	String s3Path;
	@Column(name = "IMG_URL")
	String imgUrl;
	@Column(name = "STATUS")
	Integer status;
	@Transient
	byte[] image;

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityTyp() {
		return entityTyp;
	}

	public void setEntityTyp(String entityTyp) {
		this.entityTyp = entityTyp;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getS3Path() {
		return s3Path;
	}

	public void setS3Path(String s3Path) {
		this.s3Path = s3Path;
	}

	public String getImgTyp() {
		return imgTyp;
	}

	public void setImgTyp(String imgTyp) {
		this.imgTyp = imgTyp;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
