package com.test.tweets.controller;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tweets.controller.TweetsController;
import com.tweets.model.TweetsData;
import com.tweets.service.TweetsService;

@RunWith(MockitoJUnitRunner.class)
public class TweetsControllerTest {

	@InjectMocks
	private TweetsController tweetsController;

	@Mock
	private TweetsService tweetsServiceMock;

	@Mock
	private Pageable pageableMock;

	@Mock
	private Page<TweetsData> pageDataMock;

	@Test
	public void testFetchTweets() {

		Long userId = new Long(1);

		when(tweetsServiceMock.fetchTweets(userId, pageableMock)).thenReturn(pageDataMock);
		assertThat(pageDataMock, sameInstance(tweetsController.fetchTweets(userId, pageableMock)));

	}

}
