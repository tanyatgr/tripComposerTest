package com.grushenko.test.tripcomposer_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) {
		App application = new App();
		application.run();
	}

	@SuppressWarnings("resource")
	public void run() {
		RestTemplate restTemplate = new RestTemplate();
		//create objectMapper to produce json from Request class
		ObjectMapper mapper = new ObjectMapper();
		Request request = new Request();
		String jsonInString = "";
		try {
			jsonInString = mapper.writeValueAsString(request);
			log.info("Generated json : " + jsonInString);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(),e);
			return;
		}
		//httpEntities for adding json in request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);
		//sending post 
		Response response = restTemplate.postForObject(URL, entity, Response.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ResponseService responseService = context.getBean(ResponseService.class);
		responseService.save(response);
	}
}
