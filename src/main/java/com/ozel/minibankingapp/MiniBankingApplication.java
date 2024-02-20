package com.ozel.minibankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MiniBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniBankingApplication.class, args);

	}
}
