package com.grammar.repository;

import com.grammar.repository.entity.CommonWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CommonGrammarDbReaderHelper implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(CommonGrammarDbReaderHelper.class);
    private final CommonWordRepository commonWordRepository;

    public CommonGrammarDbReaderHelper(CommonWordRepository commonWordRepository) {
        this.commonWordRepository = commonWordRepository;
    }

    @Override
    public void run() {
        readDbAndPopulateCommonPool();
    }

    public void readDbAndPopulateCommonPool(){
        List<CommonWord> commonWords = commonWordRepository.findAll();
        LOG.info(commonWords.get(0).toString());
    }


}
