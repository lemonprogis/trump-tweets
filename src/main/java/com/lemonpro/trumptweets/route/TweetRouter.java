package com.lemonpro.trumptweets.route;

import com.lemonpro.trumptweets.config.TwitterProperties;
import com.lemonpro.trumptweets.service.TweetService;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import twitter4j.Status;

@Component
@AllArgsConstructor
public class TweetRouter extends RouteBuilder {

    private final TwitterProperties twitterProperties;

    private String timelineUserUri() {
        return String.format("twitter-timeline://user?user=%s&type=%s&delay=%s" +
                        "&consumerKey=%s&consumerSecret=%s&accessToken=%s&accessTokenSecret=%s",
                twitterProperties.getUsername(),
                twitterProperties.getType(),
                twitterProperties.getPollingTime(),
                twitterProperties.getConsumerKey(),
                twitterProperties.getConsumerSecret(),
                twitterProperties.getAccessToken(),
                twitterProperties.getAccessTokenSecret());
    }

    @Override
    public void configure() throws Exception {
        String uri = timelineUserUri();
        from(uri)
                .log("Tweet received: ${body}")
                .process( exchange -> {
                    Status status = exchange.getIn().getBody(Status.class);
                    exchange.getIn().setBody(status);
                })
                .bean(TweetService.class, "showTweet");
    }
}
