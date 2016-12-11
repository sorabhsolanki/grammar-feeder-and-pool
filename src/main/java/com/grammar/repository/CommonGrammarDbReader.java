package com.grammar.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class CommonGrammarDbReader {

    private static final Logger LOG = LoggerFactory.getLogger(CommonGrammarDbReader.class);

    private final DatabaseConnection connection;

    @Autowired
    public CommonGrammarDbReader(DatabaseConnection connection){
        this.connection = connection;
        read();
    }


    public void read(){
        Set<String> names = connection.getDB().getCollectionNames();
        LOG.info("Names of collection =============== : " + names.iterator().next());
    }
}
