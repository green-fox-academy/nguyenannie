package com.greenfox.tamagochi;

import com.greenfox.tamagochi.Model.*;
import com.greenfox.tamagochi.Service.FoxService;
import com.greenfox.tamagochi.Service.TrickService;
import com.greenfox.tamagochi.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TamagochiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TamagochiApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(UserService userService, FoxService foxService, TrickService trickService) {
        return (String... args) -> {
        };
    }
}
