package com.tweets.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Represents Tweets data elements")
public interface TweetsData {

	String getComment();

	FromUserSummary getFromUser();

	ToUserSummary getToUser();

	interface FromUserSummary {
		String getUsername();
	}

	interface ToUserSummary {
		String getUsername();
	}

}
