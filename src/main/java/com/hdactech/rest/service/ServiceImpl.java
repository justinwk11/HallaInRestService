package com.hdactech.rest.service;

import org.springframework.stereotype.Service;

import com.hdactech.command.BlockCommand;
import com.hdactech.command.ChainCommand;
import com.hdactech.command.GrantCommand;
import com.hdactech.command.HdacCommand;
import com.hdactech.command.HdacException;
import com.hdactech.command.MessagingCommand;
import com.hdactech.command.StreamCommand;
import com.hdactech.command.WalletTransactionCommand;
import com.hdactech.object.Block;
import com.hdactech.rest.RestServiceApplication;

@Service
public class ServiceImpl implements ServiceInterface {
	
	@Override
	public Object ObjectGetInfo() throws HdacException {
		ChainCommand mRpcCmd = null;
		mRpcCmd = (new HdacCommand(RestServiceApplication.FULL_NODE_IP, RestServiceApplication.FULL_NODE_PORT, RestServiceApplication.RPC_USER, RestServiceApplication.RPC_PW)).getChainCommand();
		// TODO Auto-generated method stub
		return mRpcCmd.ObjectGetInfo();
	}

	@Override
	public Block getBlock(String blockHash) throws HdacException {
		BlockCommand mRpcCmd = null;
		mRpcCmd = (new HdacCommand(RestServiceApplication.FULL_NODE_IP, RestServiceApplication.FULL_NODE_PORT, RestServiceApplication.RPC_USER, RestServiceApplication.RPC_PW)).getBlockCommand();
		// TODO Auto-generated method stub
		return mRpcCmd.getBlock(blockHash);
	}
	
	@Override
	public Object getTransaction(String txid, boolean includeWatchOnly) throws HdacException {
		WalletTransactionCommand mRpcCmd = null;
		mRpcCmd = (new HdacCommand(RestServiceApplication.FULL_NODE_IP, RestServiceApplication.FULL_NODE_PORT, RestServiceApplication.RPC_USER, RestServiceApplication.RPC_PW)).getWalletTransactionCommand();
		// TODO Auto-generated method stub
		return mRpcCmd.getTransaction(txid, includeWatchOnly);
	}
	
	@Override
	public String publish(String streamName, String key, String dataHex) throws HdacException {
		StreamCommand mRpcCmd = null;
		mRpcCmd = (new HdacCommand(RestServiceApplication.FULL_NODE_IP, RestServiceApplication.FULL_NODE_PORT, RestServiceApplication.RPC_USER, RestServiceApplication.RPC_PW)).getStreamCommand();
		// TODO Auto-generated method stub
		return mRpcCmd.publish(streamName, key, dataHex);
	}

	@Override
	public String create(String entityType, String streamName, boolean open) throws HdacException {
		StreamCommand mRpcCmd = null;
		mRpcCmd = (new HdacCommand(RestServiceApplication.FULL_NODE_IP, RestServiceApplication.FULL_NODE_PORT, RestServiceApplication.RPC_USER, RestServiceApplication.RPC_PW)).getStreamCommand();
		// TODO Auto-generated method stub
		return mRpcCmd.create(entityType, streamName, open);
	}

	@Override
	public String grant(String address, String permission) throws HdacException {
		GrantCommand mRpcCmd = null;
		mRpcCmd = (new HdacCommand(RestServiceApplication.FULL_NODE_IP, RestServiceApplication.FULL_NODE_PORT, RestServiceApplication.RPC_USER, RestServiceApplication.RPC_PW)).getGrantCommand();
		return mRpcCmd.grant(address, permission);
	}

	@Override
	public String signMessage(String addressORPrivateKey, String message) throws HdacException {
		MessagingCommand mRpcCmd = null;
		mRpcCmd = (new HdacCommand(RestServiceApplication.FULL_NODE_IP, RestServiceApplication.FULL_NODE_PORT, RestServiceApplication.RPC_USER, RestServiceApplication.RPC_PW)).getMessagingCommand();
		// TODO Auto-generated method stub
		return mRpcCmd.signMessage(addressORPrivateKey, message);
	}

	@Override
	public boolean verifyMessage(String address, String signature, String message) throws HdacException {
		MessagingCommand mRpcCmd = null;
		mRpcCmd = (new HdacCommand(RestServiceApplication.FULL_NODE_IP, RestServiceApplication.FULL_NODE_PORT, RestServiceApplication.RPC_USER, RestServiceApplication.RPC_PW)).getMessagingCommand();
		// TODO Auto-generated method stub
		return mRpcCmd.verifyMessage(address, signature, message);
	}
}
