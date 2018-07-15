package com.tweets.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweets.entity.Tweets;
import com.tweets.entity.User;
import com.tweets.model.TweetsData;

@Repository
public interface TweetsRepository extends JpaRepository<Tweets, User> {
	
	Page<TweetsData> findByFromUserOrToUser(User fromUser, User toUser,Pageable pageable);
}
