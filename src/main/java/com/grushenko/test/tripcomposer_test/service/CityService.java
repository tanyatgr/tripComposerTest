package com.grushenko.test.tripcomposer_test.service;

import com.grushenko.test.tripcomposer_test.bean.City;

public interface CityService {
	
	public void save(City city);
	public void remove(long id);
	public City findById(long id);

}
