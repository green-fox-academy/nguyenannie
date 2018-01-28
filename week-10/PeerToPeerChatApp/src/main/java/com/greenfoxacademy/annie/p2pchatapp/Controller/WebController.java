package com.greenfoxacademy.annie.p2pchatapp.Controller;

import com.greenfoxacademy.annie.p2pchatapp.Model.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String getMainPage() {
        //System.out.println(new Log("/", "GET", "INFO", "fruit=apple"));
        System.out.println(System.getenv("CHAT_APP_LOGLEVEL"));
        Log.log("/", "GET", "INFO", "fruit=apple");
        Log.log("/", "GET", "ERROR", "boo=apple");
        return "index";
    }
}
