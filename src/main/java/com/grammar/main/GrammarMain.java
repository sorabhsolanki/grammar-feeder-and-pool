package com.grammar.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.grammar.feederpool.consumer.GrammarConsumer;

@SpringBootApplication
@EnableRabbit
@ComponentScan("com.grammar")
public class GrammarMain implements RabbitListenerConfigurer{

	private static final Logger LOG = LoggerFactory.getLogger(GrammarMain.class);
	
	@Autowired
	GrammarConsumer grammarConsumer;
	
	@Bean
	public MappingJackson2MessageConverter jackson2MessageConverter(){
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		return converter;
	}
	
	@Bean
    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(jackson2MessageConverter());
        return factory;
    }
	
	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
	}
	
	public static void main(String[] args) {
		LOG.info("============= From main program ===========");
		SpringApplication.run(GrammarMain.class, args);
	}
}
