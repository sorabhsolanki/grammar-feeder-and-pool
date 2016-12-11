package com.grammar.repository;

import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {

    private final MongoDbFactory dbFactory;

    @Autowired
    public DatabaseConnection(MongoDbFactory dbFactory) {
        this.dbFactory = dbFactory;
    }

    public DB getDB(){
        return this.dbFactory.getDb();
    }
}
