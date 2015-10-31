package com.grushenko.test.tripcomposer_test.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.grushenko.test.tripcomposer_test.bean.City;
import com.grushenko.test.tripcomposer_test.dao.CityDao;
import com.grushenko.test.tripcomposer_test.service.CityService;

@Named
public class CityServiceImpl implements CityService {

	@Inject
	CityDao cityDao;

	@Override
	@Transactional
	public void save(City city) {
		cityDao.saveOrUpdate(city);
	}

	@Override
	@Transactional
	public void remove(long id) {
		cityDao.remove(id);

	}

	@Override
	@Transactional
	public City findById(long id) {
		return cityDao.findById(id);
	}

}
