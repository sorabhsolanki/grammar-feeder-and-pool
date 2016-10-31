package com.grammar.feederpool.service;

import org.springframework.stereotype.Service;

import com.grammar.feeder.dto.BaseFeederDto;

@Service
public class GrammarFeederHandler implements QueueHandler<BaseFeederDto> {

	@Override
	public void handle(BaseFeederDto dto) {
		
	}

}
