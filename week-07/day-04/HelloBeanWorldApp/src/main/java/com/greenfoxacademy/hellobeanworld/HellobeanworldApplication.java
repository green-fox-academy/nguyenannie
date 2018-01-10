package com.greenfoxacademy.hellobeanworld;

import com.greenfoxacademy.hellobeanworld.Service.MyColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellobeanworldApplication implements CommandLineRunner {

	@Qualifier("redColor")
	@Autowired
	MyColor redColor;

	@Qualifier("greenColor")
	@Autowired
	MyColor greenColor;

	public static void main(String[] args) {
		SpringApplication.run(HellobeanworldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		redColor.printColor();
		greenColor.printColor();
	}
}
