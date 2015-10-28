package com.grushenko.test.tripcomposer_test.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.grushenko.test.tripcomposer_test.bean.Response;
import com.grushenko.test.tripcomposer_test.dao.ResponseDao;
import com.grushenko.test.tripcomposer_test.service.ResponseService;

@Named
public class ResponseServiceImpl implements ResponseService {

	@Inject
	ResponseDao responseDao;

	@Override
	@Transactional
	public void save(Response response) {
		responseDao.save(response);

	}

	@Override
	@Transactional
	public void remove(long id) {
		responseDao.remove(id);

	}

	@Override
	@Transactional
	public Response findById(long id) {
		return responseDao.findById(id);
	}

}
