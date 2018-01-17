package com.greenfox.tamagochi.Controller;

import com.greenfox.tamagochi.Model.Fox;
import com.greenfox.tamagochi.Model.Tamagochier;
import com.greenfox.tamagochi.Model.Trick;
import com.greenfox.tamagochi.Service.FoxServiceDBImpl;
import com.greenfox.tamagochi.Service.TrickServiceDBImpl;
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
    private final TrickServiceDBImpl trickServiceDB;
    private List<String> history = new ArrayList<>();

    @ModelAttribute("allHistory")
    public List<String> populateHistory() {
        return history;
    }

    @ModelAttribute("historysize")
    public int returnSize() {
        return history.size();
    }


    @Autowired
    public UserController(UserServiceDBImpl userServiceDB, FoxServiceDBImpl foxServiceDB, TrickServiceDBImpl trickServiceDB) {
        this.userServiceDB = userServiceDB;
        this.foxServiceDB = foxServiceDB;
        this.trickServiceDB = trickServiceDB;
    }

    @RequestMapping(value = "/tamagochi/{username}")
    public String mainPage(Model model, @PathVariable String username) {
        model.addAttribute("user", userServiceDB.getOneUserByName(username));
        model.addAttribute("fox", userServiceDB.getOneUserByName(username).getFox());
        model.addAttribute("numoftricks",
                userServiceDB.getOneUserByName(username).getFox().getNumOfTricks());
        model.addAttribute("usertricks", userServiceDB.getOneUserByName(username).getFox().getTricks());
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
        Tamagochier tamagochier = userServiceDB.getOneUserByName(username);
        if(userServiceDB.IsExisted(username) && tamagochier.getPassword().equals(password)) {
            result = "redirect:/tamagochi/" + tamagochier.getName();
            System.out.println( "redirect:/tamagochi/" + tamagochier.getName());
            model.addAttribute("user", tamagochier);
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
            Fox newFox = new Fox();
            newFox.setName(req.getParameter("setfoxname"));
            foxServiceDB.addNewFox(newFox);
            result = "redirect:/login";
        } else {
            result = "somethingwrong";
        }
        return result;
    }
    @GetMapping("/tamagochi/{username}/nutritionStore")
    public String getNutrition(Model model, @PathVariable String username){
        model.addAttribute("user",userServiceDB.getOneUserByName(username));
        Fox afox = userServiceDB.getOneUserByName(username).getFox();
        model.addAttribute("fox", afox);
        model.addAttribute("foods", foxServiceDB.getFoodValues());
        model.addAttribute("drinks", foxServiceDB.getDrinkValues());
        return "nutritionstore";
    }

    @PostMapping(value = "/tamagochi/{username}/nutritionStore")
    public String nutrition(Model model, @PathVariable String username, HttpServletRequest req) {
        Fox afox = userServiceDB.getOneUserByName(username).getFox();
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



    @GetMapping("/tamagochi/{username}/trickCenter")
    public String getTricks(Model model, @PathVariable String username){
        Fox afox = userServiceDB.getOneUserByName(username).getFox();
        model.addAttribute("fox",afox);
        model.addAttribute("user", userServiceDB.getOneUserByName(username));
        model.addAttribute("tricks", trickServiceDB.getAllTricks());
        return "trickcenter";
    }

    @PostMapping(value = "/tamagochi/{username}/trickCenter")
    public String postTricks(Model model, @PathVariable String username, HttpServletRequest req) {

        Trick newTrick = trickServiceDB.searchOneByName(req.getParameter("addtrickhere"));
        Fox afox = userServiceDB.getOneUserByName(username).getFox();

        history.add(LocalDateTime.now() + " Learned to " + req.getParameter("addtrickhere"));
        List<Trick> foxTricks = afox.getTricks();
        foxTricks.add(newTrick);
        afox.setTricks(foxTricks);
        foxServiceDB.updateFox(afox);
        System.out.println(foxTricks);
        System.out.println(afox);

        model.addAttribute("fox", afox);
        model.addAttribute("user", userServiceDB.getOneUserByName(username));
        model.addAttribute("tricks", trickServiceDB.getAllTricks());
        model.addAttribute("newtrick", newTrick);
        return "redirect:/tamagochi/" + username;
    }

    @GetMapping(value = "/tamagochi/{username}/actionhistory")
    public String getHistory(Model model, @PathVariable String username){
        Fox afox = userServiceDB.getOneUserByName(username).getFox();
        model.addAttribute("fox",afox);
        model.addAttribute("user", userServiceDB.getOneUserByName(username));
        return "actionhistory";
    }

}
