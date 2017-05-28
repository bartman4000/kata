package com.infoshare.twitter_exercise.control;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.infoshare.twitter_exercise.entity.Tweet;

import java.util.List;
import java.util.stream.Collectors;

public class TwitterSimulator {

    private final ArrayListMultimap<String, Tweet> tweets = ArrayListMultimap.create();

    private final SetMultimap<String, String> following = HashMultimap.create();

    public TwitterSimulator() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignore) {}
    }

    public void storeTweet(Tweet tweet) {
        tweets.put(tweet.getUserName(), tweet);
    }

    public List<Tweet> getTweetsByUserName(String userName) {
        return tweets.get(userName);
    }

    public void follow(String userName, String follow) {
        if (userName.equals(follow))
            throw new IllegalArgumentException("Can't follow self");

        if (!tweets.keySet().contains(follow))
            throw new IllegalStateException("User " + follow + " doesn't exists.");

        following.put(userName, follow);
    }

    public List<String> getFollowing(String userName) {
        return Lists.newArrayList(following.get(userName));
    }

    public List<Tweet> getUserAndAllFollowingTweets(String userName) {
        final List<String> following = getFollowing(userName);
        following.add(userName);

        return following.stream()
                .flatMap(user -> tweets.get(user).stream())
                .collect(Collectors.toList());
    }

    public void clearStorage() {
        tweets.clear();
        following.clear();
    }
}
