package com.wecast.request;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "job_id")
	private int id;

	@Column(name = "job_title")
	private String title;

	@Column(name = "created_date")
	private String createdDT;

	@Column(name = "job_created_by_id")
	private int createdById;

	@Column(name = "expiry_date")
	private String expiryDT;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "no_of_openings")
	private int noOfOpenigs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCreatedById() {
		return createdById;
	}

	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getNoOfOpenigs() {
		return noOfOpenigs;
	}

	public void setNoOfOpenigs(int noOfOpenigs) {
		this.noOfOpenigs = noOfOpenigs;
	}

	public String getCreatedDT() {
		return createdDT;
	}

	public void setCreatedDT(String createdDT) {
		this.createdDT = createdDT;
	}

	public String getExpiryDT() {
		return expiryDT;
	}

	public void setExpiryDT(String expiryDT) {
		this.expiryDT = expiryDT;
	}

	

}
