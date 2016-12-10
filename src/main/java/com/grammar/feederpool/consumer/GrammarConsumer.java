package com.grammar.feederpool.consumer;

import com.grammar.feeder.dto.BaseFeederDto;
import com.grammar.feederpool.service.GrammarFeederHandler;
import com.grammar.feederpool.service.GrammarPoolHandler;
import com.grammar.pool.dto.PoolRequestResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrammarConsumer {

	@Autowired
	GrammarFeederHandler feederHandler;
	
	@Autowired
	GrammarPoolHandler poolHandler;
	
	@RabbitListener(queues = "grammar-feeder-queue")
	public void receiveMessage(BaseFeederDto baseFeederDto){
		feederHandler.handle(baseFeederDto);
	}
	
	@RabbitListener(queues = "grammar-pool-queue")
	public void receiveMessage(PoolRequestResponse poolRequestResponse){
		poolHandler.handle(poolRequestResponse);
	}
}
