package com.grushenko.test.tripcomposer_test.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.grushenko.test.tripcomposer_test.bean.Country;
import com.grushenko.test.tripcomposer_test.dao.CountryDao;
import com.grushenko.test.tripcomposer_test.service.CountryService;

@Named
public class CountryServiceImpl implements CountryService {

	@Inject
	CountryDao countryDao;

	@Override
	@Transactional
	public void save(Country country) {
		countryDao.save(country);
	}

	@Override
	@Transactional
	public void remove(long id) {
		countryDao.remove(id);
	}

	@Override
	@Transactional
	public Country findById(long id) {
		return countryDao.findById(id);
	}

}
