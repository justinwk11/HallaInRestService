package com.hdactech.rest.model;

public class GrantResBean extends CommonResponseBean { //implements Serializable {

    private final String txid;

    public GrantResBean(long id, String txid) {
    	super(id);
        this.txid = txid;
    }

    public String getTxid() {
        return txid;
    }
}
