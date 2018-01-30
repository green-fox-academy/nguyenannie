package com.greenfoxacademy.annie.p2pchatapp.Controller;

import com.greenfoxacademy.annie.p2pchatapp.Model.*;
import com.greenfoxacademy.annie.p2pchatapp.Service.AppuserService;
import com.greenfoxacademy.annie.p2pchatapp.Service.MessageService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WebController {
    private final AppuserService appuserService;
    private final MessageService messageService;

    @Autowired
    public WebController(AppuserService appuserService, MessageService messageService) {
        this.appuserService = appuserService;
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String getMainPage(Form form, MessageForm messageForm, Model model) {
        model.addAttribute("defaultmessage", appuserService.findByName("App").getMessages().get(0).getText());
        model.addAttribute("app", appuserService.findByName("App").getName());
        return "index";
    }

    @PostMapping("/")
    public String postMainPage(Model model, @Valid Form form, BindingResult bindingResult) {
        String result;
        String inputname = form.getName();
        List<Appuser> appusers = appuserService.findAll();
        Appuser appuser = appuserService.findByName(inputname);
        model.addAttribute("user", appuser);
        model.addAttribute("defaultmessage", appuserService.findByName("App").getMessages().get(0).getText());
        model.addAttribute("app", appuserService.findByName("App").getName());

        if(bindingResult.hasErrors()) {
            return "index";
        }

        if(appusers.contains(appuser)) {
            result = "index";
            model.addAttribute("messages", appuser.getMessages());
            Log.log("/", "GET", "INFO", "");
        } else {
            result = "redirect:/enter";
            Log.log("/", "GET", "ERROR", "");
        }
        return result;
    }

    @PostMapping("/send/{username}")
    public String send(@PathVariable(value = "username") String username, HttpServletRequest request, Model model) {
        Appuser appuser = appuserService.findByName(username);
        model.addAttribute("user", appuser);
        Appmessage appmessage = new Appmessage(appuser, request.getParameter("textmessage"));
        messageService.save(appmessage);
        return "redirect:/";
    }

    @GetMapping("/enter")
    public String getEnter(Form enterForm) {
        return "enter";
    }

    @PostMapping("/enter")
    public String enter(@Valid Form enterForm, BindingResult bindingResult) {
        String inputname = enterForm.getName();

        if(bindingResult.hasErrors()) {
            Log.log("/", "GET", "ERROR", "");
            return "enter";
        }

        if(!appuserService.exist(inputname)) {
            Log.log("/", "GET", "INFO", "");
            Appuser appuser = new Appuser(inputname);
            appuserService.save(appuser);
        }

        return "redirect:/";
    }
}
