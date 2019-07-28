package com.lemonpro.trumptweets.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.User;

@Component("tweetService")
@Slf4j
public class TweetService {

    public void showTweet(Status status) {
        log.info(status.toString());
        User user = status.getUser();
        String name = user.getName();
        String text = status.getText();
        String screenName = user.getScreenName();
        int retweetCount = status.getRetweetCount();
    }
}
