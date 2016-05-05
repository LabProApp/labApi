package com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "S3Image")
public class S3Image {

	String Id;
	String img_type; // profile/extra
	String user_type; //Doctor/Patient/Lab Branch/Lab Office/Test Result
	String img_name;
	byte[] image;
	

	public String getId() {
		return Id;
	} 

	@XmlElement
	public void setId(String id) {
		Id = id;
	}

	public String getImg_type() {
		return img_type;
	}

	@XmlElement
	public void setImg_type(String img_type) {
		this.img_type = img_type;
	}

	public String getUser_type() {
		return user_type;
	}

	@XmlElement
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getImg_name() {
		return img_name;
	}

	@XmlElement
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public byte[] getImage() {
		return image;
	}

	@XmlElement
	public void setImage(byte[] image) {
		this.image = image;
	}
}
