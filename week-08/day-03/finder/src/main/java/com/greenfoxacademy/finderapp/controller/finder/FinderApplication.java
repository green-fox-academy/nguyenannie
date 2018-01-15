package com.greenfoxacademy.finderapp.controller.finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.greenfoxacademy.finderapp.controller"})
public class FinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinderApplication.class, args);
	}
}
