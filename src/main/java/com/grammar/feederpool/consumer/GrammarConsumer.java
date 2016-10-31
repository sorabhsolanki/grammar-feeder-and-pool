package com.grammar.feederpool.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grammar.feeder.dto.BaseFeederDto;
import com.grammar.feederpool.service.GrammarFeederHandler;
import com.grammar.feederpool.service.GrammarPoolHandler;
import com.grammar.pool.dto.PoolRequestResponse;

@Service
public class GrammarConsumer {

	@Autowired
	GrammarFeederHandler feederHandler;
	
	@Autowired
	GrammarPoolHandler poolHandler;
	
	@RabbitListener(queues = "grammer-feeder-queue")
	public void receviceMessage(BaseFeederDto baseFeederDto){
		feederHandler.handle(baseFeederDto);
	}
	
	@RabbitListener(queues = "grammer-pool-queue")
	public void receviceMessage(PoolRequestResponse poolRequestResponse){
		poolHandler.handle(poolRequestResponse);
	}
}
