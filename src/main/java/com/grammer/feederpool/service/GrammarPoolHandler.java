package com.grammer.feederpool.service;

import org.springframework.stereotype.Service;

import com.grammar.pool.dto.PoolRequestResponse;

@Service
public class GrammarPoolHandler implements QueueHandler<PoolRequestResponse>{

	@Override
	public void handle(PoolRequestResponse dto) {
		
	}

}
