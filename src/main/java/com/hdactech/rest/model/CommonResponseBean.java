package com.hdactech.rest.model;

import com.google.gson.JsonObject;

public class CommonResponseBean implements ICommonResponseBean{
	private final long id;
	private final int code;
	private final String message;
	
	public CommonResponseBean(long id) {
		this.id = id;
		this.code = 0;
		this.message = null;
	}
	
	public CommonResponseBean(long id, int code, String message) {
		this.id = id;
		this.code = code;
		this.message = message;
	}
	
	public long getId() {
		return id;
	}
	
	public long getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public static final String createResponse(long id, int code, String message, JsonObject jsonObject) {
		JsonObject jsonResult = new JsonObject();
		jsonResult.addProperty("id", id);
		jsonResult.addProperty("code", code);
		jsonResult.addProperty("message", message);
		if(jsonObject==null) return jsonResult.toString();
		jsonResult.add("result", jsonObject);
//		for(Entry<String, JsonElement> entry: jsonObject.entrySet()) {
//			jsonResult.add(entry.getKey(), entry.getValue());
//		}
		return jsonResult.toString();
	}
}
