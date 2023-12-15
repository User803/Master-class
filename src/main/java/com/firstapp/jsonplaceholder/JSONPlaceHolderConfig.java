package com.firstapp.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceHolderConfig {
	
	@Bean
	CommandLineRunner runner(JSONPlaceHolderClient jsonPlaceHolderClient) {
		return args -> {
			System.out.println(
					jsonPlaceHolderClient.getPosts().size());
			System.out.println();
			System.out.println(
					jsonPlaceHolderClient.getPost(1));
		};
	}

}
