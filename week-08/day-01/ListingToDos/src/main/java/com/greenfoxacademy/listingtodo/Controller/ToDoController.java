package com.greenfoxacademy.listingtodo.Controller;

import com.greenfoxacademy.listingtodo.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    @RequestMapping(value = {"/todo", "/"})
    public String list(Model model) {
        model.addAttribute("todos", toDoRepository.findAll());
        return "todoslist";
    }
}
