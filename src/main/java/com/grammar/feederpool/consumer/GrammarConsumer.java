package com.grammar.feederpool.consumer;

import com.grammar.feederpool.dto.BaseFeederDto;
import com.grammar.feederpool.service.GrammarFeederHandler;
import com.grammar.feederpool.service.GrammarPoolHandler;
import com.grammar.feederpool.dto.PoolRequestResponseDto;
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
	public void receiveMessage(PoolRequestResponseDto poolRequestResponseDto){
		poolHandler.handle(poolRequestResponseDto);
	}
}
