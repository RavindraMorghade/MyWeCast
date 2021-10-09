package com.wecast.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String userFirstName;
	private String userLastName;
	private String address;
}
