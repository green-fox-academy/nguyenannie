package com.greenfoxacademy.annie.p2pchatapp.Controller;

import com.greenfoxacademy.annie.p2pchatapp.Model.Appuser;
import com.greenfoxacademy.annie.p2pchatapp.Model.Log;
import com.greenfoxacademy.annie.p2pchatapp.Service.AppuserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {
    private final AppuserService appuserService;

    @Autowired
    public WebController(AppuserService appuserService) {
        this.appuserService = appuserService;
    }

    @GetMapping("/")
    public String getMainPage(Model model, HttpServletRequest request) {
        return "index";
    }

    @PostMapping("/")
    public String postMainPage(HttpServletRequest request, Model model) {
        String result;
        List<Appuser> appusers = appuserService.findAll();
        Appuser appuser = appuserService.findByName(request.getParameter("username"));
        model.addAttribute("user", appuser);
        model.addAttribute(request.getParameter("username"), "entername");

        if(appusers.contains(appuser)) {
            result = "index";
            Log.log("/", "GET", "INFO", "");
        } else {
            result = "enter";
            Log.log("/", "GET", "ERROR", "");
        }
        return result;
    }

    @GetMapping("/enter")
    public String getEnter() {
        return "enter";
    }

    @PostMapping("/enter")
    public String enter(HttpServletRequest request, Model model) {
        String inputname = request.getParameter("appuser");
        String result = "/enter";
        Appuser appuser = new Appuser(inputname);

        if(!appuserService.exist(inputname)) {
            appuserService.save(appuser);
            model.addAttribute("isemty", false);
            result = "redirect:/";
        } else if (inputname.equals("")) {
            model.addAttribute("isemty", true);
        }
        return result;
    }
}
