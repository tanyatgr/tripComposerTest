package com.grushenko.test.tripcomposer_test.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long responseId;
	private long time;
	private String echo;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "responseId") }, inverseJoinColumns = {
			@JoinColumn(name = "countryId") })
	List<Country> countries = new ArrayList<Country>();

	public long getResponseId() {
		return responseId;
	}

	public void setResponseId(long responseId) {
		this.responseId = responseId;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}	

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}

}
