package com.twitter.persistance;

import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class TweetsStatistics {

	private DBCollection collection= DBConnection.coll;
	public void printUsersWithHighestNumberOfFollowers() {
	    BasicDBObject query = new BasicDBObject();  
	     query.put("user.followers_count", -1);  
	     DBCursor cursor = collection.find().sort(query).limit(10);  
	     System.out.println("Top ten users with the highest number of followers :");
	     while (cursor.hasNext()) {  
	    	 DBObject status = cursor.next();
	    	 BasicBSONObject user = (BasicBSONObject) status.get("user");
	       System.out.println("@"+user.get("screen_name")+" Number of followers :"+user.get("followers_count") );  
	     } 
	}

	public void printTweetWithMostRetweet() {
	    BasicDBObject query = new BasicDBObject();  
	     query.put("retweet_count", -1);  
	     DBCursor cursor = collection.find().sort(query).limit(10);  
	     System.out.println("Top tweets with the highest number of retweets :");
	     while (cursor.hasNext()) {  
	    	 DBObject status = cursor.next();
	    	 BasicBSONObject user = (BasicBSONObject) status.get("user");
	       System.out.println("@"+user.get("screen_name")+":" +status.get("text")+". "+"was retweeted :"+status.get("retweet_count") );  
	     } 
	}
	
	public void printTweetWithMostFavorites() {
	    BasicDBObject query = new BasicDBObject();  
	     query.put("favorite_count", -1);  
	     DBCursor cursor = collection.find().sort(query).limit(10);
	     System.out.println("Top ten tweet with the highest number of favorites :");
	     while (cursor.hasNext()) {  
	    	 DBObject status = cursor.next(); BasicBSONObject user = (BasicBSONObject) status.get("user");
		      System.out.println("@"+user.get("screen_name")+":" +status.get("text")+". "+"was favorite :"+status.get("favorite_count") );  
	     } 
	}
	
	
	
}
