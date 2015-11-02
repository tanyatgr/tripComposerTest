package com.grushenko.test.tripcomposer_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.grushenko.test.tripcomposer_test.bean.Country;
import com.grushenko.test.tripcomposer_test.service.CountryService;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/beans.xml")
public class CountryTest extends TestCase {
	@Autowired
	ApplicationContext context;

	CountryService countryService;

	@Before
	public void setUp() {
		countryService = context.getBean(CountryService.class);
	}

	@After
	public void tearDown() {
		countryService = null;
	}
	
	@Test
	public void testSaveCountry(){
		Country country = new Country();
		country.setCountryISOCode("DE");
		country.setCountryName("Germany");
		countryService.save(country);
	}
	
	
	
}
