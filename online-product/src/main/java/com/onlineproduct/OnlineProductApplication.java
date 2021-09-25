package com.onlineproduct;

import com.onlineproduct.models.ProductDetailValue;
import com.onlineproduct.models.ProductValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OnlineProductApplication {

	private static final Logger log = LoggerFactory.getLogger(OnlineProductApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OnlineProductApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			//get an object of customer from rest request
			ProductValue product = restTemplate.getForObject(
					"http://localhost:8081/products/1", ProductValue.class);
			//get an object of contact from rest request
			ProductDetailValue details = restTemplate.getForObject(
					"http://localhost:8081/productDetails/3", ProductDetailValue.class);
			product.setProductDetail(details);
			log.info(product.toString());
		};
	}
}