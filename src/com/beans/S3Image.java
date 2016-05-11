package com.beans;

public class S3Image {

	String Id;
	Integer img_num;
	String img_type; // profile/extra
	String user_type; // Doctor/Patient/Lab Branch/Lab Office/Test Result
	String img_name;
	byte[] image;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getImg_type() {
		return img_type;
	}

	public void setImg_type(String img_type) {
		this.img_type = img_type;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getImg_num() {
		return img_num;
	}

	public void setImg_num(Integer img_num) {
		this.img_num = img_num;
	}
}
