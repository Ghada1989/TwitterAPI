package com.twitter.persistance;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class TweetsStatistics {

	private DBCollection collection= DBConnection.coll;
	public void usersWithHighestNumberOfFollowers() {
	    BasicDBObject query = new BasicDBObject();  
	     query.put("retweet_count", -1);  
	     DBCursor cursor = collection.find().sort(query).limit(10);  
	     System.out.println("items length " + collection.count());  
	     while (cursor.hasNext()) {  
	       System.out.println(cursor.next());  
	     } 
	}

}
