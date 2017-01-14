package com.grammar.feederpool.dto;

import java.util.Date;

public class CustomValueDto {

	private String name;
	
	private Date date;

	public CustomValueDto(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

    @Override
    public String toString(){
        return "Custom value : " + name + " and date : " + date;
    }
	
}
