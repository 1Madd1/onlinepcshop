package com.onlinepcshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.speedment.jpastreamer", "com.onlinepcshop"})
@EnableJpaRepositories
@ConfigurationPropertiesScan
public class OnlinePcShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePcShopApplication.class, args);
	}

}
