package com.grushenko.test.tripcomposer_test.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.grushenko.test.tripcomposer_test.bean.City;
import com.grushenko.test.tripcomposer_test.dao.CityDao;
import com.grushenko.test.tripcomposer_test.service.CityService;

@Named
public class CityServiceImpl implements CityService{
	
	@Inject
	CityDao cityDao;

	@Override
	@Transactional
	public void save(City city) {
		cityDao.save(city);
		
	}

	@Override
	@Transactional
	public void remove(long id) {
		cityDao.remove(id);
		
	}

	@Override
	@Transactional
	public City findById(long id) {
		// TODO Auto-generated method stub
		return cityDao.findById(id);
	}

}
