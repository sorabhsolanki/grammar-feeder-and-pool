package com.grammar.feeder.dto;

public class BaseFeederDto {

	private String key;
	
	private String value;
	
	private CustomValueDto customDto;

	public BaseFeederDto(String key, String value, CustomValueDto customDto) {
		this.key = key;
		this.value = value;
		this.customDto = customDto;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public CustomValueDto getCustomDto() {
		return customDto;
	}

	@Override
	public String toString(){
		return "Feeding Key : " + key + " with Value : " + value +
                " with custom value as : " + customDto;
	}
	
}
