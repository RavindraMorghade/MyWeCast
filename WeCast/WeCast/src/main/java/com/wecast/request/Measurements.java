package com.wecast.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "measurements")
public class Measurements {

	@Id
	@GeneratedValue
	@Column(name = "measurment_id")
	private int id;

	@Column(name = "height")
	private double height;

	@Column(name = "chest")
	private double chest;

	@Column(name = "hair_color")
	private String hairColor;

	@Column(name = "eye_color")
	private String eyeColor;

	@Column(name = "shoe_size")
	private int shoeSize;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "language")
	private String language;

}
