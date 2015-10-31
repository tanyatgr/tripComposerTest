package com.grushenko.test.tripcomposer_test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long cityId;
	
	@JsonProperty
	private String cityName;
	
	public City(){}
	
	public City(String cityName) {
		this.cityName = cityName;
	}

	public long getCity_id() {
		return cityId;
	}

	public void setCity_id(long city_id) {
		this.cityId = city_id;
	}

	public String getName() {
		return cityName;
	}

	public void setName(String name) {
		this.cityName = name;
	}

}
