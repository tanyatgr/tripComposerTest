package com.grushenko.test.tripcomposer_test.service;

import com.grushenko.test.tripcomposer_test.bean.Response;

public interface ResponseService {	
	public void save(Response response);
	public void remove(long id);
	public Response findById(long id);

}
