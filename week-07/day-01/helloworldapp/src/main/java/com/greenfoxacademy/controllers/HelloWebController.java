package com.greenfoxacademy.controllers;

import com.greenfoxacademy.model.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@SpringBootApplication
public class HelloWebController {

    AtomicLong atomicLong = new AtomicLong(3);
    String [] contents = new String[]{"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
            "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
            "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
            "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

    public static void main(String[] args) {
        SpringApplication.run(HelloWebController.class, args);
    }

    @RequestMapping(value = "/web/greeting")
    public String greeting(@RequestParam(value = "name", required = false) String name, Model model) {

        List<Greeting> g = new ArrayList<>();
        for(String greet : contents) {
            Random r = new Random();
            g.add(new Greeting(atomicLong.addAndGet(1), greet + " " + name,
                    new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))));
        }

        model.addAttribute("greetings", g);

        return "greeting";
    }
}
