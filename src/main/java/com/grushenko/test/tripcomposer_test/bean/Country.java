package com.grushenko.test.tripcomposer_test.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "country")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long countryId;
	private String countryName;
	private String countryISOCode;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinTable(name = "city", joinColumns = @JoinColumn(name = "countryId") , inverseJoinColumns = @JoinColumn(name = "cityId") )
	private Set<City> cities = new HashSet<City>();

	public long getId() {
		return countryId;
	}

	public void setId(long id) {
		this.countryId = id;
	}

	public String getName() {
		return countryName;
	}

	public void setName(String name) {
		this.countryName = name;
	}

	public String getISOCode() {
		return countryISOCode;
	}

	public void setISOCode(String iSOCode) {
		countryISOCode = iSOCode;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}
