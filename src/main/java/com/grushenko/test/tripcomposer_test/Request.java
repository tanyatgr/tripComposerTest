package com.grushenko.test.tripcomposer_test;

import java.util.UUID;

public class Request {

	private final String key = "$1$12309856$euBrWcjT767K2sP9MHcVS/";
	private String echo;

	public Request() {
		String uuid = UUID.randomUUID().toString();
		this.echo = uuid;
	}

	public String getEcho() {
		return echo;
	}

	public String getKey() {
		return key;
	}

}
