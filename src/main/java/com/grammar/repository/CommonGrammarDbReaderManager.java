package com.grammar.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class CommonGrammarDbReaderManager {

    private static final Logger LOG = LoggerFactory.getLogger(CommonGrammarDbReaderManager.class);
    public static final String GRAMMAR = "grammar";

    private final CommonGrammarRepository commonGrammarRepository;
    private final CommonGrammarDbReaderHelper commonGrammarDbReaderHelper;

    @Autowired
    public CommonGrammarDbReaderManager(CommonGrammarRepository commonGrammarRepository) {
        this.commonGrammarRepository = commonGrammarRepository;
        commonGrammarDbReaderHelper = new CommonGrammarDbReaderHelper(commonGrammarRepository);
        initializeBackGroundServiceForFeedInitialGrammar();
    }

    private void initializeBackGroundServiceForFeedInitialGrammar() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        //scheduledExecutorService.scheduleAtFixedRate(locationGraph, 0, 60, TimeUnit.SECONDS);
        //currently it is only scheduled for once, above is the code for iteration after every 60 sec.
        scheduledExecutorService.schedule(commonGrammarDbReaderHelper, 60, TimeUnit.SECONDS);
    }


}
