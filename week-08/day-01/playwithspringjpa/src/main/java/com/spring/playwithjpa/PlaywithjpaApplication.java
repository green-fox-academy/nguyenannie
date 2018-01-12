package com.spring.playwithjpa;

import com.spring.playwithjpa.Entity.AnnieHouseMember;
import com.spring.playwithjpa.Repository.AnnieHomeRepository;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PlaywithjpaApplication {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(PlaywithjpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AnnieHomeRepository homeRepository) {
	    return (String... args) -> {
	        homeRepository.save(new AnnieHouseMember("Annie", "Nguyen"));
	        homeRepository.save(new AnnieHouseMember("Krisztian", "Pinter"));
	        homeRepository.save(new AnnieHouseMember("Rub", "Rub"));
	        homeRepository.save(new AnnieHouseMember("Son", "Son"));

	        log.info("AnnieHouseMember found with findAll():");
	        log.info("------------------------------");
	        for(AnnieHouseMember pet : homeRepository.findAll()) {
                log.info(pet.toString());
            }
            log.info("");

	        AnnieHouseMember ket = homeRepository.findOne(1L);
            log.info("AnnieHouseMember found with findOne(1L):");
            log.info("------------------------------");
            log.info(ket.toString());
            log.info("");

            log.info("AnnieHouseMember found with findByLastName()");
            log.info("------------------------------");
            for(AnnieHouseMember fatKet : homeRepository.findByLastName("Rub")) {
                log.info(fatKet.toString());
            }
            log.info("");
        };
    }

}
