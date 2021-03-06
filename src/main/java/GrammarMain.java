import com.grammar.feederpool.consumer.GrammarConsumer;
import com.grammar.repository.CommonGrammarDbReaderManager;
import com.grammar.util.QueueRouteTopicDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@SpringBootApplication
@EnableAutoConfiguration
@EnableRabbit
@EnableMongoRepositories
@ComponentScan()
public class GrammarMain implements RabbitListenerConfigurer{

	private static final Logger LOG = LoggerFactory.getLogger(GrammarMain.class);
	
	@Autowired
	private GrammarConsumer grammarConsumer;

	@Autowired
	private QueueRouteTopicDeclaration queueRouteTopicDeclaration;

    // dbreader to read common grammar key value from DB and feed it to common pool
	@Autowired
	private CommonGrammarDbReaderManager grammarDbReader;

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
