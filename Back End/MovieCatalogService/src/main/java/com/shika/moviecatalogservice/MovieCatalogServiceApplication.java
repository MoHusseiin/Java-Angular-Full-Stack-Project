package com.shika.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan("com.shika")
@EnableEurekaClient
public class MovieCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced  // tell Rest Template don't go to service directly whatever url i'm giving you cause is not the actual one it just a hint for what service i need to discover
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
//	@LoadBalanced // tell web client don't go to service directly whatever url i'm giving you cause is not the actual one it just a hint for what service i need to discover
	public WebClient.Builder getBuilder() {
		return WebClient.builder();
	}
}
