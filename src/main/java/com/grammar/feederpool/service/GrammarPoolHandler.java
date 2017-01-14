package com.grammar.feederpool.service;

import com.grammar.feederpool.dto.PoolRequestResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GrammarPoolHandler implements QueueHandler<PoolRequestResponseDto>{

	private static final Logger LOG = LoggerFactory.getLogger(GrammarFeederHandler.class);

	@Override
	public void handle(PoolRequestResponseDto dto) {
        LOG.info("handling request " + dto);
	}

}
