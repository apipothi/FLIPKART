package com.apipothi.flipkart;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

//http://localhost:8081/swagger-ui.html

@SpringBootApplication
@EnableFeignClients("com.apipothi.flipkart")
@EnableDiscoveryClient
public class FlipkartApplication {
	private final static Logger logger = LoggerFactory.getLogger(FlipkartApplication.class);
	public static void main(String[] args) {
		logger.info("***FlipkartApplication-START");
		SpringApplication.run(FlipkartApplication.class, args);
		logger.info("***FlipkartApplication-END");
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
