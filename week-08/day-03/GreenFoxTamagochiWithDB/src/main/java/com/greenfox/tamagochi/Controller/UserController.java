package com.greenfox.tamagochi.Controller;

import com.greenfox.tamagochi.Model.Fox;
import com.greenfox.tamagochi.Model.Tamagochier;
import com.greenfox.tamagochi.Service.FoxServiceDBImpl;
import com.greenfox.tamagochi.Service.UserServiceDBImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserServiceDBImpl userServiceDB;
    private final FoxServiceDBImpl foxServiceDB;
    private List<String> history = new ArrayList<>();

    @ModelAttribute("allHistory")
    public List<String> populateHsitory() {
        return history;
    }

    @ModelAttribute("historysize")
    public int returnSize() {
        return history.size();
    }


    @Autowired
    public UserController(UserServiceDBImpl userServiceDB, FoxServiceDBImpl foxServiceDB) {
        this.userServiceDB = userServiceDB;
        this.foxServiceDB = foxServiceDB;
    }

    @RequestMapping(value = "/tamagochi/{username}")
    public String mainPage(Model model, @PathVariable String username) {
        model.addAttribute("user", userServiceDB.getOneUser(username));
        model.addAttribute("fox", userServiceDB.getOneUser(username).getFox());
        model.addAttribute("numoftricks", userServiceDB.getOneUser(username).getFox().getTricks().size());
        return "mainpage";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        return "login";
    }

    @PostMapping(value = "/login")
    public String postLoginPage(Model model, HttpServletRequest req) {
        String result;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(userServiceDB.IsExisted(username) && userServiceDB.getByName(username).getPassword().equals(password)) {
            result = "redirect:/tamagochi/" + req.getParameter("username");
            model.addAttribute("user", userServiceDB.getOneUser(req.getParameter("username")));
        } else {
            result = "register";
        }
        return result;
    }
    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String postRegisterPage(Model model, HttpServletRequest req) {
        String result;
        String password = req.getParameter("setpassword");
        String confirmPassword = req.getParameter("confirmpassword");
        if(password.equals(confirmPassword)) {
            Tamagochier newRegister = new Tamagochier();
            newRegister.setName(req.getParameter("setname"));
            newRegister.setPassword(password);
            userServiceDB.addNewUser(newRegister);
            result = "redirect:/login";
        } else {
            result = "somethingwrong";
        }
        return result;
    }
    @GetMapping("tamagochi/{username}/nutritionStore")
    public String getNutrition(Model model, @PathVariable String username){
        model.addAttribute("user",userServiceDB.getOneUser(username));
        Fox afox = userServiceDB.getOneUser(username).getFox();
        model.addAttribute("fox", afox);
        model.addAttribute("foods", foxServiceDB.getFoodValues());
        model.addAttribute("drinks", foxServiceDB.getDrinkValues());
        return "nutritionstore";
    }

    @PostMapping(value = "tamagochi/{username}/nutritionStore")
    public String nutrition(Model model, @PathVariable String username, HttpServletRequest req) {
        Fox afox = userServiceDB.getOneUser(username).getFox();
        if(!afox.getFood().equals(req.getParameter("addfoodhere"))){
            history.add(LocalDateTime.now() + " Food has been change from "
                    + afox.getFood() + " to " + req.getParameter("addfoodhere"));
        }

        if(!afox.getDrink().equals(req.getParameter("adddrinkhere"))) {
            history.add(LocalDateTime.now() + " Drink has been change from "
                    + afox.getDrink() + " to " + req.getParameter("adddrinkhere"));
        }

        afox.setDrink(req.getParameter("adddrinkhere"));
        afox.setFood(req.getParameter("addfoodhere"));
        foxServiceDB.save(afox);

        model.addAttribute("fox", afox);
        return "redirect:/tamagochi/" + username;
    }



    @GetMapping("tamagochi/{username}/trickCenter")
    public String getTricks(Model model, @PathVariable String username){
        Fox afox = userServiceDB.getOneUser(username).getFox();
        model.addAttribute("fox",afox);
        model.addAttribute("tricks", afox.getTricks());
        return "trickcenter";
    }
/*
    @PostMapping(value = "tamagochi/{username}/trickCenter")
    public String postTricks(Model model, @PathVariable String username, HttpServletRequest req) {
        String result = "alreadylearned";
        Fox afox = userServiceDB.getOneUser(username).getFox();
        if(!foxService.findOne(username).existed(req.getParameter("addtrickhere"))) {
            history.add(LocalDateTime.now() + " Learned to " + req.getParameter("addtrickhere"));
            foxService.findOne(username).addTrick(req.getParameter("addtrickhere"));
            foxService.findOne(username).addLearnedTrick(req.getParameter("addtrickhere"));
            result = "redirect:/foxclub/" + username;
        }

        model.addAttribute("fox", foxService.findOne(username));
        model.addAttribute("learnedTricks", foxService.findOne(username).getLearnedTricks());
        return result;
    }
*/

    @GetMapping(value = "tamagochi/{username}/actionhistory")
    public String getHistory(Model model, @PathVariable String username){
        Fox afox = userServiceDB.getOneUser(username).getFox();
        model.addAttribute("fox",afox);
        return "actionhistory";
    }

}
