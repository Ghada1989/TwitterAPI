package com.twitter.analysis;

import java.util.ArrayList;
import java.util.List;

import com.twitter.configuration.TwitterConfigurator;
import com.twitter.persistance.TweetsStatistics;

import twitter4j.Query;
import twitter4j.Query.ResultType;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TweetsDigest {

	private TweetsStatistics tweetsStatistics = new TweetsStatistics();

	public List<Status> getDigest(String keyword) {
		Twitter twitter = TwitterConfigurator.getTwitterFactory();
		Query query = new Query(keyword);
		query.count(10);
		query.resultType(ResultType.popular);
		List<Status> status = new ArrayList<Status>();
		int i=0;
		try {
			do {
				QueryResult result = twitter.search(query);
				status.addAll(result.getTweets());
				i++;
			} while (i<=10);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return status;
	}

	public void printTopTenUserWithHighestNumberOfFollowers() {
		tweetsStatistics.printUsersWithHighestNumberOfFollowers();
	}

	public void printTweetWithMostFavorites() {
		tweetsStatistics.printTweetWithMostFavorites();
	}

	public void printTweetWithMostRetweet() {
		tweetsStatistics.printTweetWithMostRetweet();
	}
}
