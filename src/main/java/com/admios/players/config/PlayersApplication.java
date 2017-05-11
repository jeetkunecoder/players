package com.admios.players.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages = {"com.admios.players"})
@PropertySources({ @PropertySource("classpath:application.properties") })
public class PlayersApplication {

	public static final String API_V1 = "/api/v1/";

	public static void main(String[] args) {
		SpringApplication.run(PlayersApplication.class, args);
	}
}
