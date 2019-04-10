package com.hdactech.rest.service;

import com.hdactech.command.HdacException;
import com.hdactech.object.Address;
import com.hdactech.object.Block;

public interface ServiceInterface {
	
	public Object ObjectGetInfo() throws HdacException;
	
	public abstract Block getBlock(String blockHash) throws HdacException;
	
	public Object getTransaction(String txid, boolean includeWatchOnly) throws HdacException;
	
	public abstract String publish(String streamName, String key, String dataHex) throws HdacException;
	
	public abstract String create(String entityType, String streamName, boolean open) throws HdacException;
	
	public abstract String grant(String address, String permission) throws HdacException;
	
	public abstract String signMessage(String addressORPrivateKey, String message) throws HdacException;
	
	public abstract boolean verifyMessage(String address, String signature, String message) throws HdacException;
}
