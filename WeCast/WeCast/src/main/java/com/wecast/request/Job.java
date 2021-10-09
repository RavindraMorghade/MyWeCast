package com.wecast.request;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
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

}
