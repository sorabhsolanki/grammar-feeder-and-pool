package com.grammar.repository;

import com.grammar.repository.entity.CommonGrammar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonGrammarRepository extends MongoRepository<CommonGrammar, String>{

    @Override
    public List<CommonGrammar> findAll();
}
