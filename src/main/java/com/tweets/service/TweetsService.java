package com.tweets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweets.entity.User;
import com.tweets.exception.TweetsNotFoundException;
import com.tweets.model.TweetsData;
import com.tweets.repository.TweetsRepository;

@Service
public class TweetsService {

	@Autowired
	TweetsRepository tweetsRepository;

	public Page<TweetsData> fetchTweets(Long userId, Pageable pageable) throws TweetsNotFoundException {
		
		User fromUser = new User();
		fromUser.setId(userId);
		User toUser = new User();
		toUser.setId(userId);
		
		Page<TweetsData> tweetsSet = tweetsRepository.findByFromUserOrToUser(fromUser,toUser, pageable);
		if (tweetsSet.getContent().isEmpty()) {
			throw new TweetsNotFoundException("Tweets not found");
		}

		return tweetsSet;
	}

}
