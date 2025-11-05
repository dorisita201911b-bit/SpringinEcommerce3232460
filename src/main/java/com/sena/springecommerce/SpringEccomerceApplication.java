package com.sena.springecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  DataSourceAutoConfiguration.class)
public class SpringEccomerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEccomerceApplication.class, args);
	}

}
