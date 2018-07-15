package com.tweets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tweets.exception.TweetsNotFoundException;
import com.tweets.model.TweetsData;
import com.tweets.service.TweetsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Tweets API")
public class TweetsController {

	@Autowired
	TweetsService tweetsService;

	@GetMapping("/tweets/{userId}")
	@ApiOperation(value = "Fetch Tweets for User")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = TweetsData.class),
			@ApiResponse(code = 500, message = "Server Error") })
	public Page<TweetsData> fetchTweets(
			@ApiParam(name = "userId", value = "user id", required = true) @PathVariable(value = "userId") Long userId,
			Pageable pageable) throws TweetsNotFoundException {
		return tweetsService.fetchTweets(userId, pageable);

	}

}
