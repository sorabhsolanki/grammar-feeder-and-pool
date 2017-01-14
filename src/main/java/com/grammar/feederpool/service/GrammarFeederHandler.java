package com.grammar.feederpool.service;

import com.grammar.feederpool.dto.BaseFeederDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GrammarFeederHandler implements QueueHandler<BaseFeederDto> {

	private static final Logger LOG = LoggerFactory.getLogger(GrammarFeederHandler.class);

	@Override
	public void handle(BaseFeederDto dto) {
		LOG.info("handling feed " + dto);
	}

}
