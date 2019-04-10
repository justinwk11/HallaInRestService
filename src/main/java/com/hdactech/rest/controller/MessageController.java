package com.hdactech.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hdactech.command.HdacException;
import com.hdactech.rest.model.CommonResponseBean;
import com.hdactech.rest.model.ICommonResponseBean;
import com.hdactech.rest.model.SignMessageResBean;
import com.hdactech.rest.model.VerifyMessageResBean;
import com.hdactech.rest.service.ServiceInterface;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	ServiceInterface Service;
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/signmessage", method = RequestMethod.POST)
	@ResponseBody
	public ICommonResponseBean jsonSM(@RequestBody String payload) {
		
		JsonParser parser = new JsonParser();
		
		JsonObject jsonObject = parser.parse(payload).getAsJsonObject();
		
		String addressORPrivateKey = jsonObject.get("addressORPrivateKey").getAsString();
		String message = jsonObject.get("message").getAsString();
		
		String signMessage = null;
		
		try {
			signMessage = Service.signMessage(addressORPrivateKey, message);
		} catch (HdacException e) {
			return new CommonResponseBean(counter.incrementAndGet(), -500, e.getMessage());
		}
		return new SignMessageResBean(counter.incrementAndGet(), signMessage);
	}
	
	@RequestMapping(value = "/verifymessage", method = RequestMethod.POST)
	@ResponseBody
	public ICommonResponseBean jsonVM(@RequestBody String payload) {
		
		JsonParser parser = new JsonParser();
		
		JsonObject jsonObject = parser.parse(payload).getAsJsonObject();
		
		String address = jsonObject.get("address").getAsString();
		String signature = jsonObject.get("signature").getAsString();
		String message = jsonObject.get("message").getAsString();
		
		boolean result;
		
		try {
			result = Service.verifyMessage(address, signature, message);
		} catch (HdacException e) {
			return new CommonResponseBean(counter.incrementAndGet(), -500, e.getMessage());
		}
		return new VerifyMessageResBean(counter.incrementAndGet(), result);
	}
}
