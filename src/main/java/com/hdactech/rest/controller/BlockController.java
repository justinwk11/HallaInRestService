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
import com.hdactech.object.Block;
import com.hdactech.rest.model.CommonResponseBean;
import com.hdactech.rest.model.GetBlockResBean;
import com.hdactech.rest.model.ICommonResponseBean;
import com.hdactech.rest.service.ServiceInterface;

@RestController
@RequestMapping("/block")
public class BlockController {

	@Autowired
	ServiceInterface Service;
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/getblock", method = RequestMethod.POST)
	@ResponseBody
	public ICommonResponseBean jsonGB(@RequestBody String payload) {
		
		JsonParser parser = new JsonParser();
		
		JsonObject jsonObject = parser.parse(payload).getAsJsonObject();
		
		String blockHash = jsonObject.get("blockhash").getAsString();
		Block getBlock = null;
		
		try {
			getBlock = Service.getBlock(blockHash);
		} catch (HdacException e) {
			return new CommonResponseBean(counter.incrementAndGet(), -500, e.getMessage());
		}
		return new GetBlockResBean(counter.incrementAndGet(), getBlock);
	}
}