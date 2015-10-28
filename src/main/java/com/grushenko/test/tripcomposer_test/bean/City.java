package com.grushenko.test.tripcomposer_test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "city")
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cityId;
	private String name;
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	public long getCity_id() {
		return cityId;
	}

	public void setCity_id(long city_id) {
		this.cityId = city_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
