package com.greenfoxacademy.mysqlconnect;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import com.greenfoxacademy.mysqlconnect.Model.Todo;
import com.greenfoxacademy.mysqlconnect.Service.AssigneeService;
import com.greenfoxacademy.mysqlconnect.Service.ToDoServiceDBImpl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MysqlconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlconnectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AssigneeService assigneeService, ToDoServiceDBImpl toDoServiceDB) {
    	return (String... args) -> {
		};
	}
}
