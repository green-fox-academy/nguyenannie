package com.greenfoxacademy.annie.p2pchatapp.Controller;

import com.greenfoxacademy.annie.p2pchatapp.Model.*;
import com.greenfoxacademy.annie.p2pchatapp.Service.AppuserService;
import com.greenfoxacademy.annie.p2pchatapp.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String getMainPage(Model model) {
        if(appuserService.findAll().size() > 1) {
            Appuser appuser = appuserService.findAll().get(1);
            model.addAttribute("appuser", appuser);
            model.addAttribute("errormessage", "");
            model.addAttribute("messages", messageService.findAll());
            model.addAttribute("appmessage", new Appmessage(appuser, ""));
            System.out.println(appuser);
            System.out.println(appuserService.findAll());
            return "index";
        } else {
            return "redirect:/enter";
        }
    }

    @PostMapping("/")
    public String update(@ModelAttribute(value = "appuser") Appuser appuser, Model model) {
        String error;
        if(appuser.getUsername().isEmpty()) {
            error = "This field cannot be null";
        } else {
            error = "";
            appuserService.save(appuser);
        }
        model.addAttribute("appuser", appuser);
        model.addAttribute("errormessage", error);
        model.addAttribute("appmessage", new Appmessage(appuser, ""));
        return "index";
    }

//    Use HttpServletRequest and PathVariable
//    @PostMapping("/send/{username}")
//    public String send(@PathVariable(value = "username") String username, HttpServletRequest request) {
//        Appmessage appmessage = new Appmessage(appuserService.findByName(username), request.getParameter("textmessage"));
//        messageService.save(appmessage);
//        return "redirect:/";
//    }

    @PostMapping("/send")
    public String send(@ModelAttribute(value = "appmessage") Appmessage appmessage, Model model) {
        String error;
        if(appmessage.getText().isEmpty()) {
            error = "This field cannot be null!";
            model.addAttribute("errormessage", error);
        } else {
            error = "";
            messageService.save(appmessage);
            model.addAttribute("errormessage", error);
        }
        return "redirect:/";
    }

    @GetMapping("/enter")
    public String getEnter(Model model) {
        if (appuserService.findAll().size() > 1) {
            return "redirect:/";
        } else {
            model.addAttribute("appuser", new Appuser());
            model.addAttribute("errormessage", "");
            return "enter";
        }
    }

    @PostMapping("/enter")
    public String postEnter(Model model, @ModelAttribute(value = "appuser") Appuser appuser) {
        String error;
        if(appuser.getUsername() == null) {
            error = "This field cannot be null";
            model.addAttribute("errormessage", error);
            return "enter";
        }

        if(!appuserService.exist(appuser.getUsername())) {
            appuserService.save(appuser);
            error = "";
            model.addAttribute("errormessage", error);
            return "redirect:/";
        } else {
            error = "This username already exists";
            model.addAttribute("errormessage", error);
            return "enter";
        }
    }


    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("messages", messageService.findAll());
    }
}

//@CookieValue(value = "username", defaultValue = "annie") String username
/*
@GetMapping("/")
    public String getMainPage(Form form, Model model) {
        model.addAttribute("messages", messageService.findAll());
        return "index";
    }

    @PostMapping("/")
    public String postMainPage(Model model, @Valid Form form, BindingResult bindingResult) {
        String result;
        String inputname = form.getUsername();
        List<Appuser> appusers = appuserService.findAll();
        Appuser appuser = appuserService.findByName(inputname);
        model.addAttribute("user", appuser);

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
    public String send(@PathVariable(value = "username") String username, HttpServletRequest request, Model model, HttpServletResponse response) {
        Appuser appuser = appuserService.findByName(username);
        model.addAttribute("user", appuser);
        model.addAttribute("messages", appuser.getMessages());
        Appmessage appmessage = new Appmessage(appuser, request.getParameter("textmessage"));
        messageService.save(appmessage);
        return "redirect:/";
    }

    @PostMapping("/enter")
    public String enter(@Valid Form enterForm, BindingResult bindingResult) {
        String inputname = enterForm.getUsername();

        if(bindingResult.hasErrors()) {
            Log.log("/", "POST", "ERROR", "");
            return "enter";
        }

        if(!appuserService.exist(inputname)) {
            Log.log("/", "POST", "INFO", "");
            Appuser appuser = new Appuser(inputname);
            appuserService.save(appuser);
            return "redirect:/";
        } else {
            return "enter";
        }
    }

 */