package com.twitter.configuration;

import com.twitter.persistance.SaveTweet;

import twitter4j.StallWarning;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class TwitterStatusListener {
	private static int COUNT = 0;
	public static StatusListener listener = new StatusListener() {

		@Override
		public void onException(Exception arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTrackLimitationNotice(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStatus(twitter4j.Status status) {
			if (COUNT < 100) {
				SaveTweet saveTweet = new SaveTweet();
				saveTweet.save(status);
				COUNT++;
			}
		}

		@Override
		public void onStallWarning(StallWarning arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onScrubGeo(long arg0, long arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onDeletionNotice(StatusDeletionNotice arg0) {
			// TODO Auto-generated method stub

		}
	};
}
