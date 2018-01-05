package com.greenfox.nguyenannie.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class HelloRESTController {

	public static void main(String[] args) {
		SpringApplication.run(HelloRESTController.class, args);
	}

	@ResponseBody
	@RequestMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value = "name", required = false) String name, Model map) {
		map.addAttribute("Your name is: " + name);
		return new Greeting(15, "hello " + name);
	}

}
