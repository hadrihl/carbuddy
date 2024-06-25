package com.example.carbuddy.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String brand;
	
	private String model;
	
	private String description;
	
	private Integer year;
	
	private String variant; 
	
	private String transmission; 
	
	@Column(name = "fuel_type")
	private String fueltype;
	
	private String location;
	
	private Float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuelType() {
		return fueltype;
	}

	public void setFuelType(String fuelType) {
		this.fueltype = fueltype;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFueltype() {
		return fueltype;
	}

	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
}
