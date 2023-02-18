package com.example.springbootRedisWithDocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootRedisWithDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisWithDockerApplication.class, args);
	}

}
