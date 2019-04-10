package com.hdactech.rest.model;

import java.io.Serializable;

public class SignMessageResBean extends CommonResponseBean implements Serializable {

	private final String signature;
	
	public SignMessageResBean(long id, String signature) {
		super(id);
		this.signature = signature;
		// TODO Auto-generated constructor stub
	}

	public String getSignature() {
		return signature;
	}
}
