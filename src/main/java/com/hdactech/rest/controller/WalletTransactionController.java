package com.hdactech.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/wallettransaction")
public class WalletTransactionController {

	@Autowired
	ServiceInterface Service;
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/gettx", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String jsonGT(@RequestBody String payload) {
		
		JsonParser parser = new JsonParser();
		
		JsonObject jsonObject = parser.parse(payload).getAsJsonObject();
		
		String txid = jsonObject.get("txid").getAsString();
		Boolean includeWatchOnly = jsonObject.get("includewatchonly").getAsBoolean();
		
		Object gettransaction = null;
		
		try {
			gettransaction = Service.getTransaction(txid, includeWatchOnly); //일정 부족으로 임시로 이렇게 고침. 완전 바이패스. hjs0317
		} catch (HdacException e) {
			return CommonResponseBean.createResponse(counter.incrementAndGet(), -500, e.getMessage(), null);
		}
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String jsonResult = gson.toJson(gettransaction);
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonResultObject = (JsonObject) jsonParser.parse(jsonResult);
		return CommonResponseBean.createResponse(counter.incrementAndGet(), 0, null, jsonResultObject);
	}
}
