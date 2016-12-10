package com.grammar.feederpool.service;

import com.grammar.pool.dto.PoolRequestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GrammarPoolHandler implements QueueHandler<PoolRequestResponse>{

	private static final Logger LOG = LoggerFactory.getLogger(GrammarFeederHandler.class);

	@Override
	public void handle(PoolRequestResponse dto) {
        LOG.info("handling request " + dto);
	}

}
