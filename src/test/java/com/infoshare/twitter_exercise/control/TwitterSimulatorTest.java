package com.infoshare.twitter_exercise.control;

import com.infoshare.twitter_exercise.entity.Tweet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.fail;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * 1. Zaimplementuj pierwszy test.
 * 2. Przyśpiesz testy wykorzystując znane funkcjonalności JUnit'a, niech TwitterSimulator będzie tworzony tylko raz.
 * 3. Po każdym teście należy wyczyścić TwitterSimulator wywołując metodę clearStorage()
 * 4. Zaimplementuj resztę testów
 */
public class TwitterSimulatorTest {

    private TwitterSimulator twitterSimulator = new TwitterSimulator();

    @After
    public void clear()
    {
        twitterSimulator.clearStorage();
    }

    @Test
    public void should_store_new_tweet() {

        //when
        Tweet tweet = new Tweet("Bob", "Hello world");
        twitterSimulator.storeTweet(tweet);

        //then
        List<Tweet> bobTweets = twitterSimulator.getTweetsByUserName("Bob");
        assertThat(bobTweets, hasItem(tweet));

    }

    @Test
    public void should_store_new_tweets_for_multiple_users() {

        //when
        Tweet tweet = new Tweet("Bob", "Hello world");
        twitterSimulator.storeTweet(tweet);

        //when
        Tweet tweet2 = new Tweet("John", "Hello Bob");
        twitterSimulator.storeTweet(tweet2);

        //then
        List<Tweet> bobTweets = twitterSimulator.getTweetsByUserName("Bob");
        List<Tweet> johnTweets = twitterSimulator.getTweetsByUserName("John");

        assertThat(bobTweets, hasItem(tweet));
        assertThat(johnTweets, hasItem(tweet2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_follow_self() {

        //when
        twitterSimulator.follow("Bob","Bob");

    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_when_follow_user_who_doesnt_exists() {
        twitterSimulator.follow("Bob","John");
    }

    @Test
    public void should_follow_John_and_Alice() {

        //when
        Tweet tweet = new Tweet("Bob", "Hello world");
        twitterSimulator.storeTweet(tweet);

        Tweet tweet2 = new Tweet("John", "Hello world");
        twitterSimulator.storeTweet(tweet2);

        Tweet tweet3 = new Tweet("Alice", "Hello world");
        twitterSimulator.storeTweet(tweet3);

        twitterSimulator.follow("Bob", "John");
        twitterSimulator.follow("Bob", "Alice");

        //then
        List<String> followings = twitterSimulator.getFollowing("Bob");
        assertThat(followings, allOf(hasItem("John"), hasItem("Alice")));
    }

    @Test
    public void should_return_own_and_following_tweets() {

        //when
        Tweet tweet = new Tweet("Bob", "Hello world");
        twitterSimulator.storeTweet(tweet);

        Tweet tweet2 = new Tweet("John", "Hello Bob");
        twitterSimulator.storeTweet(tweet2);

        twitterSimulator.follow("Bob", "John");

        //then
        List<Tweet> bobAllTweets = twitterSimulator.getUserAndAllFollowingTweets("Bob");
        assertThat(bobAllTweets, allOf(hasItem(tweet),hasItem(tweet2)));
    }
}