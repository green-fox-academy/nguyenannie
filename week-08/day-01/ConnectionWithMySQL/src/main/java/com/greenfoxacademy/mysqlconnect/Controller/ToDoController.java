package com.greenfoxacademy.mysqlconnect.Controller;

import com.greenfoxacademy.mysqlconnect.Model.ToDo;
import com.greenfoxacademy.mysqlconnect.Repository.ToDoRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        ToDo newTodo = new ToDo();
        newTodo.setTitle(req.getParameter("addtitle"));
        newTodo.setDone(Boolean.parseBoolean(req.getParameter("adddone")));
        newTodo.setUrgent(Boolean.parseBoolean(req.getParameter("addurgent")));
        toDoRepository.save(newTodo);
        model.addAttribute("todos", toDoRepository.findAll());
        return "redirect:/mainpage";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(Model model, @PathVariable(value="id") long id) {
        toDoRepository.delete(id);
        model.addAttribute("todos", toDoRepository.findAll());
        return "redirect:/mainpage";
    }

    @GetMapping(value = {"/todo/{id}/edit"})
    public String showEditoDo(Model model, @PathVariable(value="id") long id) {
        model.addAttribute("todo", toDoRepository.findOne(id));
        return "edittodo";
    }

    @PostMapping(value = {"/todo/{id}/edit"})
    public String editTodo(Model model, @PathVariable(value="id") long id, HttpServletRequest req) {
        ToDo needtoedittodo = toDoRepository.findOne(id);
        needtoedittodo.setTitle(req.getParameter("settitle"));
        needtoedittodo.setCreation_time(req.getParameter("setdate"));
        needtoedittodo.setDone(Boolean.parseBoolean(req.getParameter("setdone")));
        needtoedittodo.setUrgent(Boolean.parseBoolean(req.getParameter("seturgent")));
        toDoRepository.save(needtoedittodo);
        model.addAttribute("todo", toDoRepository.findOne(id));
        return "redirect:/mainpage";
    }
}
