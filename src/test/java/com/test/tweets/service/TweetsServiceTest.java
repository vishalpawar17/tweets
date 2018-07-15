package com.test.tweets.service;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tweets.exception.TweetsNotFoundException;
import com.tweets.model.TweetsData;
import com.tweets.repository.TweetsRepository;
import com.tweets.service.TweetsService;

@RunWith(MockitoJUnitRunner.class)
public class TweetsServiceTest {

	@InjectMocks
	TweetsService tweetsService;

	@Mock
	TweetsRepository tweetsRepositoryMock;

	@Mock
	private Pageable pageableMock;

	@Mock
	private Page<TweetsData> pageDataMock;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testFetchTweets() {

		List<TweetsData> tweetsDataList = new ArrayList<TweetsData>();
		tweetsDataList.add(new TweetsDataImpl());

		when(tweetsRepositoryMock.findByFromUserOrToUser(Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(pageDataMock);

		when(pageDataMock.getContent()).thenReturn(tweetsDataList);

		assertThat(pageDataMock, sameInstance(tweetsService.fetchTweets(new Long(1), pageableMock)));

		tweetsService.fetchTweets(new Long(1), pageableMock);

	}

	@Test
	public void testFetchTweetsNotFounfException() {
		exception.expect(TweetsNotFoundException.class);
		exception.expectMessage("Tweets not found");

		when(tweetsRepositoryMock.findByFromUserOrToUser(Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(pageDataMock);

		tweetsService.fetchTweets(new Long(1), pageableMock);

	}

	class TweetsDataImpl implements TweetsData {

		public String getComment() {

			return "test comment";
		}

		public FromUserSummary getFromUser() {

			return null;
		}

		public ToUserSummary getToUser() {

			return null;
		}

	}

}
