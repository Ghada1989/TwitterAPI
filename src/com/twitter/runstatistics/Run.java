package com.twitter.runstatistics;

import com.twitter.analysis.TweetsDigest;

public class Run {

	public static void main(String[] args) {
		TweetsDigest digest= new TweetsDigest();
		String[] keywords ={"SaudiArabia"};
		digest.getDigest(keywords );
		digest.getTopTenUserWithHighestNumberOfFollowers();
	}

}
