package com.hdactech.rest.model;

import java.io.Serializable;

import com.hdactech.object.Block;

public class GetBlockResBean extends CommonResponseBean implements Serializable {
	
	private final Block getBlock;
	
	public GetBlockResBean(long id, Block getBlock) {
		super(id);
		this.getBlock = getBlock;
		// TODO Auto-generated constructor stub
	}

	public Block getGetBlock() {
		return getBlock;
	}
}
