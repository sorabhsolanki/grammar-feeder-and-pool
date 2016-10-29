package com.grammer.feederpool.service;

public interface QueueHandler<T> {

	public void handle(T t);
	
}
