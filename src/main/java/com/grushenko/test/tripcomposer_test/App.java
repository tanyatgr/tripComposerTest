package com.grushenko.test.tripcomposer_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grushenko.test.tripcomposer_test.bean.Response;
import com.grushenko.test.tripcomposer_test.service.ResponseService;

public class App {
	private String URL = "http://tripcomposer.net/rest/test/countries/get";

	public static void main(String[] args) {
		App application = new App();
		application.run();

	}

	@SuppressWarnings("resource")
	public void run() {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		Request request = new Request();
		String jsonInString = "";
		try {
			jsonInString = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			return;
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);
		Response response = restTemplate.postForObject(URL, entity, Response.class);
		System.out.println(response.getCountries().size());
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ResponseService responseService = context.getBean(ResponseService.class);
		responseService.save(response);
	}
}
