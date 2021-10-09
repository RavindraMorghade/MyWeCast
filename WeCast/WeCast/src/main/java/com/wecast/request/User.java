package com.wecast.request;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue
	private int id;

	@Column(name = "user_name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	private String dob;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "reg_date")
	private String regDate;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	private Measurements measurement;

}
