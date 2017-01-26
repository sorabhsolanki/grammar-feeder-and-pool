package com.grammar.repository;

import com.grammar.repository.entity.CustomGrammar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomGrammarRepository extends MongoRepository<CustomGrammar, String> {

    @Override
    public CustomGrammar insert(CustomGrammar customGrammar);

    @Query("[{'user':?0},{'keyName':?1}]")
    public CustomGrammar findByLoggedInUserAndKeyName(String userName, String keyName);
}
