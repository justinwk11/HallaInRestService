package com.hdactech.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

	public static final String FULL_NODE_IP = "192.168.70.61";
	public static final String FULL_NODE_PORT = "6824";
	public static final String RPC_USER = "hdacrpc";
	public static final String RPC_PW = "hdac1234";
	
	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
}
