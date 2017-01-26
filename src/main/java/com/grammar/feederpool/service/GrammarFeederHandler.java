package com.grammar.feederpool.service;

import com.grammar.feederpool.dto.BaseFeederDto;
import com.grammar.repository.CustomGrammarRepository;
import com.grammar.repository.dto.Key;
import com.grammar.repository.entity.CustomGrammar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrammarFeederHandler implements QueueHandler<BaseFeederDto> {

	private static final Logger LOG = LoggerFactory.getLogger(GrammarFeederHandler.class);

	@Autowired
	CustomGrammarRepository customGrammarRepository;

	@Override
	public void handle(BaseFeederDto dto) {
		LOG.info("handling feed " + dto);
		CustomGrammar customGrammar = customGrammarRepository.findByLoggedInUserAndKeyName(dto.getLoggedInUser(),
				dto.getKey());
		if(customGrammar != null){
			List<Key> keys = customGrammar.getKeys();
			for(Key key : keys){
				if(key.getKeyName().equals(dto.getKey())){
					// add value
					//key.getValues().add();
				}
			}
		}else{
			// make new CustomGrammar instance from BaseFeederDto and then insert into DB.
		}
	}

}
