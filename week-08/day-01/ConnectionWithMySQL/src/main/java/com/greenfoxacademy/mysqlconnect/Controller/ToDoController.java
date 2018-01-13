package com.greenfoxacademy.mysqlconnect.Controller;

import com.greenfoxacademy.mysqlconnect.Model.ToDo;
import com.greenfoxacademy.mysqlconnect.Repository.ToDoRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    @RequestMapping(value = {"/mainpage"})
    public String list(Model model) {
        model.addAttribute("todos", toDoRepository.findAll());
        return "todoslist";
    }

    @RequestMapping(value = {"/todo"})
    public String listIsDone(Model model, @RequestParam("isActive") boolean b) {
        if(b == true) {
            model.addAttribute("todos", toDoRepository.findByDoneFalse());
        } else {
            model.addAttribute("todos",toDoRepository.findByDoneTrue());
        }
        return "activetodo";
    }

    @GetMapping(value = {"/todo/add"})
    public String showadd(Model model) {
        model.addAttribute("todos", toDoRepository.findAll());
        return "addtodo";
    }

    @PostMapping(value = {"/todo/add"})
    public String add(Model model, HttpServletRequest req) {
        ToDo newTodo = new ToDo(req.getParameter("addNewOne"));
        toDoRepository.save(newTodo);
        model.addAttribute("todos", toDoRepository.findAll());
        return "redirect:/mainpage";
    }
}
