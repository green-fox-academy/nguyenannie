package com.greenfoxacademy.listingtodo;

import com.greenfoxacademy.listingtodo.Entity.ToDo;
import com.greenfoxacademy.listingtodo.Repository.ToDoRepository;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ListingtodoApplication {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(ListingtodoApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(ToDoRepository toDoRepository) {
        return (String... args) -> {
            toDoRepository.save(new ToDo("Learn how to connect Java object and Database"));
            toDoRepository.save(new ToDo("Learn how to use Spring JPA"));
            toDoRepository.save(new ToDo("Understand bean"));
            toDoRepository.save(new ToDo("Finish the exercises"));

            log.info("AnnieHouseMember found with findAll():");
            log.info("------------------------------");
            for(ToDo todo : toDoRepository.findAll()) {
                log.info(todo.toString());
            }
            log.info("");
        };
    }
}
