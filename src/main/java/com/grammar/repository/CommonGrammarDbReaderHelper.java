package com.grammar.repository;

import com.grammar.repository.entity.CommonGrammar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CommonGrammarDbReaderHelper implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(CommonGrammarDbReaderHelper.class);
    private final CommonGrammarRepository commonGrammarRepository;

    public CommonGrammarDbReaderHelper(CommonGrammarRepository commonGrammarRepository) {
        this.commonGrammarRepository = commonGrammarRepository;
    }

    @Override
    public void run() {
        readDbAndPopulateCommonPool();
    }

    public void readDbAndPopulateCommonPool(){
        List<CommonGrammar> commonGrammars = commonGrammarRepository.findAll();
        LOG.info(commonGrammars.get(0).toString());
    }


}
