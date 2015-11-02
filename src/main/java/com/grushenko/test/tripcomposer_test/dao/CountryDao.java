package com.grushenko.test.tripcomposer_test.dao;

import java.util.Set;

import com.grushenko.test.tripcomposer_test.bean.City;
import com.grushenko.test.tripcomposer_test.bean.Country;

public interface CountryDao extends GenericDao<Country>{
	
	public Country findCountryByNameAndISO(Country country);

	public void updateCities(long countryId, Set<City> cities);

}
