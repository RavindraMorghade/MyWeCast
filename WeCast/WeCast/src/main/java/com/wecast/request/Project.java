package com.wecast.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project")
@Builder
public class Project {

	@Id
	@GeneratedValue
	@Column(name = "project_id")
	private int pid;

	@Column(name = "project_desc")
	private String desc;

	@Column(name = "project_name")
	private String name;

	@Column(name = "project_createdBy")
	private int createdBy;

}
