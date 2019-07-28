package com.lemonpro.trumptweets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.lemonpro.trumptweets")
public class TrumpTweetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrumpTweetsApplication.class, args);
	}

}
