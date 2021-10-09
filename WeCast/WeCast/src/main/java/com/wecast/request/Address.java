package com.wecast.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private int id;

	@Column(name = "local_address")
	private String localAddress;

	@Column(name = "permanent_address")
	private String permanentAddress;

	@Column(name = "city")
	private String city;

	@Column(name = "area")
	private String area;

	@Column(name = "street")
	private String street;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "pincode")
	private int pincode;

}
