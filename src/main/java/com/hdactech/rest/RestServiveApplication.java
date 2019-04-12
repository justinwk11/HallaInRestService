package com.hdactech.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiveApplication {

	public static final String FULL_NODE_IP = "192.168.70.61";
	public static final String FULL_NODE_PORT = "7180";
	public static final String RPC_USER = "generator2";
	public static final String RPC_PW = "hdac1234";
	
	public static void main(String[] args) {
		SpringApplication.run(RestServiveApplication.class, args);
	}
}
