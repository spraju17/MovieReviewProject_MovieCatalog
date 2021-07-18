package com.spraju.moviecatalog;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MoviecatalogApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getResttemplateInstance(RestTemplateBuilder restTemplateBuilder) {
		//HttpComponentsClientHttpRequestFactory x=new HttpComponentsClientHttpRequestFactory();
		//x.setConnectTimeout(5000);
		
		//return new RestTemplate(x);
		return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(1))
                .setReadTimeout(Duration.ofSeconds(1))
                .build();
		//return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MoviecatalogApplication.class, args);
	}

}
