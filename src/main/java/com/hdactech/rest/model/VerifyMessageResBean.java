package com.hdactech.rest.model;

import java.io.Serializable;

public class VerifyMessageResBean extends CommonResponseBean implements Serializable {

	private final boolean result;
	
	public VerifyMessageResBean(long id, boolean result) {
		super(id);
		this.result = result;
		// TODO Auto-generated constructor stub
	}

	public boolean isResult() {
		return result;
	}
}
