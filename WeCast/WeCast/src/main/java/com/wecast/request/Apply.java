package com.wecast.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "apply")
public class Apply {

	@Id
	@GeneratedValue
	private int aId;

	@Column(name = "apply_by_userId")
	private int userId;

	@Column(name = "jobid")
	private int jobId;

	@Column(name = "status")
	private String status;

}
