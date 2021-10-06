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
@Table(name="measurements")
public class Measurements {
	
	@Id
	@GeneratedValue
	@Column(name="measurment_id")
	private int id;
	
	@Column(name="height")
	private double height;
	
	@Column(name="chest")
	private double chest;
	
	@Column(name="hair_color")
	private String hairColor;
	
	@Column(name="eye_color")
	private String eyeColor;
	
	@Column(name="shoe_size")
	private int shoeSize;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="language")
	private String language;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getChest() {
		return chest;
	}
	public void setChest(double chest) {
		this.chest = chest;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public int getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(int shoeSize) {
		this.shoeSize = shoeSize;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	
}
