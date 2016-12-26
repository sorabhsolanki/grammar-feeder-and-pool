package com.grammar.repository;

import com.grammar.repository.entity.CommonWord;
import com.mongodb.DBCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonGrammarDbReader {

    private static final Logger LOG = LoggerFactory.getLogger(CommonGrammarDbReader.class);
    public static final String GRAMMAR = "grammar";

    private CommonWordRepository commonWordRepository;

    @Autowired
    public CommonGrammarDbReader(CommonWordRepository commonWordRepository) {
        this.commonWordRepository = commonWordRepository;
        readDbAndPopulateCommonPool();
    }

    public void readDbAndPopulateCommonPool(){
        List<CommonWord> commonWords = commonWordRepository.findAll();
        LOG.info(commonWords.get(0).toString());
    }


    //ToDO: add support for executor service so that read from DB can be scheduled and run independently.
}
