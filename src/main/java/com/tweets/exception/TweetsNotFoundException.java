package com.tweets.exception;

public class TweetsNotFoundException extends RuntimeException {
	public TweetsNotFoundException(String message) {
		super(message);
	}
}
