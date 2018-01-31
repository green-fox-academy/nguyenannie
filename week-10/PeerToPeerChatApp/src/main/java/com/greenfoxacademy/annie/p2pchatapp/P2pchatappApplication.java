package com.greenfoxacademy.annie.p2pchatapp;

import com.greenfoxacademy.annie.p2pchatapp.Model.Appmessage;
import com.greenfoxacademy.annie.p2pchatapp.Model.Appuser;
import com.greenfoxacademy.annie.p2pchatapp.Service.AppuserService;
import com.greenfoxacademy.annie.p2pchatapp.Service.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class P2pchatappApplication {

	public static void main(String[] args) {
		SpringApplication.run(P2pchatappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AppuserService appuserService, MessageService messageService) {
		return (String... args) -> {
			Appuser appuser = new Appuser("App");
			Appmessage appmessage = new Appmessage(appuser, "Hi there! Submit your message using the send button!");
			appuser.setMessages(Collections.singletonList(appmessage));
			appuserService.save(appuser);
			messageService.save(appmessage);
		};
	}
}
