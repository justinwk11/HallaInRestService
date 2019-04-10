package com.hdactech.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hdactech.command.HdacException;
import com.hdactech.rest.model.CommonResponseBean;
import com.hdactech.rest.service.ServiceInterface;

@RestController
@RequestMapping("/chain")
public class ChainController {

	@Autowired
	ServiceInterface Service;
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/getinfo", method = { RequestMethod.POST, RequestMethod.GET}, produces="application/json")
	@ResponseBody
	public String jsonGI() {
		
		Object getInfo = null;
		
		try {
			getInfo = Service.ObjectGetInfo(); 
		} catch (HdacException e) {
			return CommonResponseBean.createResponse(counter.incrementAndGet(), -500, e.getMessage(), null);
		}
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String jsonResult = gson.toJson(getInfo);
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonResult);
		return CommonResponseBean.createResponse(counter.incrementAndGet(), 0, null, jsonObject);
	}
}
