package com.grushenko.test.tripcomposer_test.dao.impl;

import org.springframework.stereotype.Repository;

import com.grushenko.test.tripcomposer_test.bean.Country;
import com.grushenko.test.tripcomposer_test.dao.CountryDao;

@Repository
public class CountryDoaImpl extends GenericDaoImpl<Country> implements CountryDao{

}
