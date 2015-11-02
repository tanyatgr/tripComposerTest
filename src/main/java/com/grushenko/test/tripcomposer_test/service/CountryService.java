package com.grushenko.test.tripcomposer_test.service;

import com.grushenko.test.tripcomposer_test.bean.Country;

public interface CountryService {
	public void save(Country country);
	public void remove(long id);
	public Country findById(long id);
	
}
