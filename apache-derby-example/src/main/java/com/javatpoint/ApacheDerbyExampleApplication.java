package com.javatpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApacheDerbyExampleApplication {

	public static void main(String[] args) {
		System.out.println("start");
		SpringApplication.run(ApacheDerbyExampleApplication.class, args);
		System.out.println("end");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

}
