package com.grammar.feederpool.dto;

public class BaseFeederDto {

	private final String loggedInUser;

	private final String key;
	
	private final String value;
	
	private final CustomValueDto customDto;

	public BaseFeederDto(String loggedInUser, String key, String value, CustomValueDto customDto) {
		this.loggedInUser = loggedInUser;
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

	public String getLoggedInUser() {
		return loggedInUser;
	}

	@Override
	public String toString(){
		return "Feeding Key : " + key + " with Value : " + value +
                " with custom value as : " + customDto + " of User : " + loggedInUser;
	}
	
}
