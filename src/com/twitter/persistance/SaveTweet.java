package com.twitter.persistance;

import java.util.List;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import twitter4j.Status;
import twitter4j.TwitterObjectFactory;

public class SaveTweet {

	public void save(List<Status> statuses) {
			for (Status status:statuses) {
				String tweet = TwitterObjectFactory.getRawJSON(status);
				DBObject doc = (DBObject) JSON.parse(tweet);
				DBCollection coll = DBConnection.coll;
				coll.insert(doc);
			}
		
	}
}
