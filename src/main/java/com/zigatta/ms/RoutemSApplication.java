package com.zigatta.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import com.zigatta.ms.common.SystemProperties;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableAsync
@EnableCaching
public class RoutemSApplication {

	public static void main(String[] args) {
		SystemProperties.loadSystemProperties();
		SpringApplication.run(RoutemSApplication.class, args);
	}
}
