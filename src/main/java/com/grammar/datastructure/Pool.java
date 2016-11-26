package com.grammar.datastructure;

public interface Pool {

	public boolean feed(String word, Value value);
	
	public Value get(String word);
}
