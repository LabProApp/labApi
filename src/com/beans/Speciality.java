package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPECIALITY")
public class Speciality {

	@Override
	public String toString() {
		return "Speciality [specId=" + specId + ", specName=" + specName
				+ ", search_tags=" + search_tags + ", status=" + status + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPEC_ID", unique = true)
	Long specId;

	@Column(name = "SPEC_NAME")
	String specName;
	@Column(name = "SEARCH_TAGS")
	String search_tags;
	@Column(name = "STATUS")
	Integer status;

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSearch_tags() {
		return search_tags;
	}

	public void setSearch_tags(String search_tags) {
		this.search_tags = search_tags;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
