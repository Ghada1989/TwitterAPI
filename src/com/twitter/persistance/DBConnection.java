package com.twitter.persistance;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DBConnection {
	protected static DBCollection coll;
	static {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("test");
			coll = db.getCollection("tweets");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
