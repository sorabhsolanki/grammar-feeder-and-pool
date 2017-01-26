package com.grammar.repository.dto;

import java.util.List;

public class Key {

    private String keyName;

    private List<Value> values;

    public Key() {
    }

    public Key(String keyName, List<Value> values) {
        this.keyName = keyName;
        this.values = values;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}
