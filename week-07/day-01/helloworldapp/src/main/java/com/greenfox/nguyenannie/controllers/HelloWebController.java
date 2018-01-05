package com.greenfox.nguyenannie.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        SpringApplication.run(HelloRESTController.class, args);
    }

    @ResponseBody
    @RequestMapping(value = "/web/greeting")
    public Greeting greeting(@RequestParam(value = "name", required = false) String[] names, Model map) {
        map.addAttribute("Your name is: " + names);
        Greeting g = null;
        for(String name : names) {
            g =  new Greeting(atomicLong.addAndGet(1), name);
        }
        return g;
    }
}
