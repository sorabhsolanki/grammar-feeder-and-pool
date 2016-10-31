package com.grammar.feederpool.service;

public interface QueueHandler<T> {

	public void handle(T t);
	
}
