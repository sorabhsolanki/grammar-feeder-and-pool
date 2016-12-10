package com.grammar.pool.dto;

public class PoolRequestResponse {

	private String key;
	
	private String value;

	public PoolRequestResponse(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
    public String toString(){
        return "Requesting Key : " + key + " Value received : " + value;
    }
}
