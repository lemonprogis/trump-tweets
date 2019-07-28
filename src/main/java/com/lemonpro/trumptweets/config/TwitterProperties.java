package com.lemonpro.trumptweets.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twitter")
@Getter
@Setter
public class TwitterProperties {
    private String accessToken;
    private String accessTokenSecret;
    private String consumerKey;
    private String consumerSecret;
    private String username;
    private String pollingTime;
    private String type;
}
