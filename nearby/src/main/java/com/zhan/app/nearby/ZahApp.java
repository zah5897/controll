package com.zhan.app.nearby;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@Configurable
@ComponentScan(basePackages = {"com.zhan.app"})
public class ZahApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(ZahApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ZahApp.class, args);
	}
}
