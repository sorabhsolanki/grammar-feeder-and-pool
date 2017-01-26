package com.grammar.repository.entity;

import com.grammar.repository.dto.Key;
import com.grammar.repository.dto.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "custom_grammar")
public class CustomGrammar {

    @Id
    private String id;

    @Field(value = "user")
    private String loggedInUser;

    private List<Key> keys;

    public CustomGrammar() {
    }

    public CustomGrammar(String id, String loggedInUser, List<Key> keys) {
        this.id = id;
        this.loggedInUser = loggedInUser;
        this.keys = keys;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }
}
