package com.grammar.repository;

import com.grammar.repository.entity.CommonWord;
import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonWordRepository extends MongoRepository<CommonWord, String>{
    @Override
    public List<CommonWord> findAll();
}
