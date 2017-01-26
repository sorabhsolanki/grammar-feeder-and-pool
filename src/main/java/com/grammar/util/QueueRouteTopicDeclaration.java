package com.grammar.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*
* The class is designed for making the service independent.
* By this the service can be started standalone.
*/
@Component
public class QueueRouteTopicDeclaration {

    private static final Logger LOG = LoggerFactory.getLogger(QueueRouteTopicDeclaration.class);

    @Bean
    Queue queueForGrammarFeeder() {
        return new Queue("grammar-feeder-queue", false);
    }

    @Bean
    Queue queueForGrammarPool() {
        return new Queue("grammar-pool-queue", false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("grammar-feeder-and-pool");
    }

    @Bean
    Binding bindingExchangeFoo(Queue queueForGrammarFeeder, TopicExchange exchange) {
        return BindingBuilder.bind(queueForGrammarFeeder).to(exchange).with("grammar-feeder-queue-key");
    }

    @Bean
    Binding bindingExchangeBar(Queue queueForGrammarPool, TopicExchange exchange) {
        return BindingBuilder.bind(queueForGrammarPool).to(exchange).with("grammar-pool-queue-key");
    }
}
