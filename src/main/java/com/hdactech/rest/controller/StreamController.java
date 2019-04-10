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
import com.hdactech.rest.model.CreateResBean;
import com.hdactech.rest.model.ICommonResponseBean;
import com.hdactech.rest.model.PublishResBean;
import com.hdactech.rest.service.ServiceInterface;

@RestController
@RequestMapping("/stream")
public class StreamController {
	
	@Autowired
	ServiceInterface Service;
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ICommonResponseBean jsonC(@RequestBody String payload) {

		JsonParser parser = new JsonParser();

		JsonObject jsonObject = parser.parse(payload).getAsJsonObject();
		
		String entityType = jsonObject.get("entitytype").getAsString();
		String streamName = jsonObject.get("streamname").getAsString();
		boolean open = jsonObject.get("open").getAsBoolean();
		
		String stringCreate = null;
		
		try {
			stringCreate = Service.create(entityType, streamName, open);
		} catch (HdacException e) {
			return new CommonResponseBean(counter.incrementAndGet(), -500, e.getMessage());
		}
		return new CreateResBean(counter.incrementAndGet(), stringCreate);
	}
	
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	@ResponseBody
	public ICommonResponseBean jsonP(@RequestBody String payload) {

		JsonParser parser = new JsonParser();

		JsonObject jsonObject = parser.parse(payload).getAsJsonObject();
		
		String streamName = jsonObject.get("streamname").getAsString();
		String key = jsonObject.get("key").getAsString();
		String dataHex = jsonObject.get("datahex").getAsString();
		
		String stringPublish = null;
		
		try {
			stringPublish = Service.publish(streamName, key, dataHex);
		} catch (HdacException e) {
			return new CommonResponseBean(counter.incrementAndGet(), -500, e.getMessage());
		}
		return new PublishResBean(counter.incrementAndGet(), stringPublish);
	}
}
