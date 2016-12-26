package com.grammar.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "grammar")
public class CommonWord {

    @Id
    private String id;

    private String key;
    private String value;

    public CommonWord() {
    }

    public CommonWord(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Grammar[id=%s, key='%s', value='%s']", id,
                key, value);
    }
}
