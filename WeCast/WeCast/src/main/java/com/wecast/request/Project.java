package com.wecast.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project")
public class Project {
	
	@Id
	@GeneratedValue
	@Column(name="project_id")
	private int pid;
	
	@Column(name="project_desc")
	private String desc;
	
	@Column(name="project_name")
	private String name;
	
	@Column(name="project_createdBy")
	private int createdBy;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	

}
