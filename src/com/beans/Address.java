package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ADDRESS")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Address")
public class Address {
	@Override
	public String toString() {
		return "Address [AddressLine1=" + addressLine1 + ", AddressLine2="
				+ addressLine2 + ", AddressLine3=" + addressLine3 + ", City="
				+ city + ", State=" + state + ", Zip=" + zip + ", Country="
				+ country + "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "CUST_ID")
	String addressId;
	@Column(name = "CUST_ID1")
	String addressLine1;
	@Column(name = "ADD_LINE2")
	String addressLine2;
	@Column(name = "ADD_LINE3")
	String addressLine3;
	@Column(name = "CITY")
	String city;
	@Column(name = "STATE")
	String state;
	@Column(name = "ZIP")
	String zip;
	@Column(name = "COUNTRY")
	String country;

	public String getAddressLine1() {
		return addressLine1;
	}

	@XmlElement
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	@XmlElement
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	@XmlElement
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	@XmlElement
	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	@XmlElement
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}
}
