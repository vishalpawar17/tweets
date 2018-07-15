package com.tweets.runner;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tweets.entity.Tweets;
import com.tweets.entity.User;
import com.tweets.repository.TweetsRepository;
import com.tweets.repository.UserRepository;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TweetsRepository tweetsRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
	
		User savedUser1 = userRepository.save(new User("John"));
		User savedUser2 = userRepository.save(new User("Mary"));
		User savedUser3 = userRepository.save(new User("Peter"));
		User savedUser4 = userRepository.save(new User("Robert"));
		User savedUser5 = userRepository.save(new User("David"));

		log.info("New User is created1 : " + savedUser1);
		log.info("New User is created2 : " + savedUser2);
		log.info("New User is created3 : " + savedUser3);
		log.info("New User is created4: " + savedUser4);
		log.info("New User is created5 : " + savedUser5);
		List<Tweets> tweetList = new ArrayList<Tweets>();
		
		Tweets tweet = null;
		for(int j =1 ;  j < 200 ; j++ ) { 
		for(int i = 1 ; i < 11; i++) {
			double commentInt = Math.random() +1;
			
			switch(i) {
			
			case 1 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser1, savedUser2);
				break;
			}
			
			case 2 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser1, savedUser3);
				break;
			}
			
			case 3 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser2, savedUser1);
				break;
			}
			case 4 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser3, savedUser2);
				break;
			}
			
			case 5 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser3, savedUser4);
				break;
			}
			
			case 6 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser4, savedUser3);
				break;
			}
			case 7 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser4, savedUser3);
				break;
			}
			case 8 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser5, savedUser4);
				break;
			}
			case 9 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser5, savedUser2);
				break;
			}
			case 10 : {
				tweet  = new Tweets("Test comment"+commentInt, savedUser5, savedUser3);
				break;
			}
			
			}
		
			
			tweetList.add(tweet);
		}
		}
		tweetsRepository.saveAll(tweetList);
	
	}
	
}