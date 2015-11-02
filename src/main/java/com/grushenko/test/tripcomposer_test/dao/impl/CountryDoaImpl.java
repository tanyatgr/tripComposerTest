package com.grushenko.test.tripcomposer_test.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.grushenko.test.tripcomposer_test.bean.City;
import com.grushenko.test.tripcomposer_test.bean.Country;
import com.grushenko.test.tripcomposer_test.dao.CountryDao;

@Repository
public class CountryDoaImpl extends GenericDaoImpl<Country> implements CountryDao{

	public Country findCountryByNameAndISO(Country country){
		TypedQuery<Country> query = em.createQuery("select  distinct c from Country c where c.countryName"
				+ "= :countryName AND c.countryISOCode = :countryISOCode", Country.class);
		query.setParameter("countryName", country.getCountryName());
		query.setParameter("countryISOCode", country.getCountryISOCode());
		List<Country> results = query.getResultList();
		Country foundCountry = null;
		if(!results.isEmpty()){
			foundCountry = results.get(0);
		}
		return foundCountry;
		
	}

	@Override
	public void updateCities(long countryId, Set<City> cities) {
		Country country  = em.find(Country.class, countryId);
		if(country!=null){
			for(City city : cities){
				country.getCities().add(city);
			}
		}
		
	} 
}
