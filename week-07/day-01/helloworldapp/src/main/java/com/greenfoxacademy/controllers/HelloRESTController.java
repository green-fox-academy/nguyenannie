package com.greenfoxacademy.controllers;

import com.greenfoxacademy.model.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;


@Controller
@SpringBootApplication
public class HelloRESTController {

	AtomicLong atomicLong = new AtomicLong(0);

	public static void main(String[] args) {
		SpringApplication.run(HelloRESTController.class, args);
	}

	@ResponseBody
	@RequestMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value = "name", required = false) String name, Model map) {
		map.addAttribute("Your name is: " + name);
		return new Greeting(atomicLong.addAndGet(1), "hello " + name, Color.BLACK);
	}
}
