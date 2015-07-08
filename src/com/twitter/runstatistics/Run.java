package com.twitter.runstatistics;

import java.util.List;

import twitter4j.Status;

import com.twitter.analysis.TweetsDigest;
import com.twitter.persistance.SaveTweet;

public class Run {

	private static TweetsDigest digest= new TweetsDigest();
	private static List<Status> status;

	public static void main(String[] args) {
		getTweets();
		saveTweets();
		printStatistics();
	}

	private static void getTweets() {
		status=digest.getDigest("#TelAvivLive");
	}

	private static void saveTweets()  {
		SaveTweet saveTweet = new SaveTweet();
		saveTweet.save(status);
	}
	private static void printStatistics() {
		digest.printTopTenUserWithHighestNumberOfFollowers();
		digest.printTweetWithMostRetweet();
		digest.printTweetWithMostFavorites();		
	}

}
