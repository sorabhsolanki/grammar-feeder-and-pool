package com.grammar.feederpool.dto;

public class PoolRequestResponseDto {

	private String key;
	
	private String value;

	public PoolRequestResponseDto(String key, String value) {
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
