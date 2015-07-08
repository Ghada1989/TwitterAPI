package com.twitter.configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfigurator {

	public static Twitter getTwitterFactory() {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true);
		configurationBuilder.setOAuthConsumerKey("Krnx8iFUJY6C69Ie7cSWUjUd2");
		configurationBuilder
				.setOAuthConsumerSecret("hS9SmiiTTHMNjwI3SOTe4BhgX3gYfYL0b2qUAfavMU3c2kIOqy");
		configurationBuilder.setJSONStoreEnabled(true);
		configurationBuilder
				.setOAuthAccessToken("165953037-EvCKafAXNPhjzb9nGTRME2OcPlJfZOOJcnOIwo5E");
		configurationBuilder
				.setOAuthAccessTokenSecret("cVFqZHG7duSpEeLHr06oJPQ6I0VFDsTMuxzjksoYruJC8");
		return new TwitterFactory(configurationBuilder.build()).getInstance();
	}

}
