package com.twitter.analysis;

import com.twitter.configuration.TwitterStatusListener;
import com.twitter.configuration.TwitterStreamConfigurator;
import com.twitter.persistance.TweetsStatistics;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;

public class TweetsDigest {

	TweetsStatistics tweetsStatistics=new TweetsStatistics();
	public void getDigest(String keywords[]) {
		TwitterStream twitterStream = TwitterStreamConfigurator
				.getTwitterStream();

		FilterQuery filterQ = new FilterQuery();
		filterQ.track(keywords);

		twitterStream.addListener(TwitterStatusListener.listener);
		twitterStream.filter(filterQ);
	}

	public void getTopTenUserWithHighestNumberOfFollowers() {
		tweetsStatistics.usersWithHighestNumberOfFollowers();		
	}

}
