package com.greenfoxacademy.mysqlconnect.Controller;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import com.greenfoxacademy.mysqlconnect.Model.Todo;
import com.greenfoxacademy.mysqlconnect.Service.AssigneeServiceDBImpl;
import com.greenfoxacademy.mysqlconnect.Service.ToDoServiceDBImpl;
import com.sun.corba.se.impl.oa.toa.TOA;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoController {

    private final
    ToDoServiceDBImpl toDoServiceDB;

    private final
    AssigneeServiceDBImpl assigneeServiceDB;

    @Autowired
    public ToDoController(ToDoServiceDBImpl toDoServiceDB, AssigneeServiceDBImpl assigneeServiceDB) {
        this.toDoServiceDB = toDoServiceDB;
        this.assigneeServiceDB = assigneeServiceDB;
    }

    @ModelAttribute("assignees")
    public List<Assignee> populateAssignee() {
        return assigneeServiceDB.getAllAssignees();
    }

    @ModelAttribute("todos")
    public List<Todo> populateTodos() {
        return toDoServiceDB.getAllTodos();
    }

    @RequestMapping(value = {"/mainpage"})
    public String list(Model model) {
        return "todoslist";
    }

    @RequestMapping(value = {"/todo"})
    public String listIsDone(Model model, @RequestParam("isActive") boolean active) {
        if(active) {
            model.addAttribute("todos", toDoServiceDB.findByDoneFalse());
        } else {
            model.addAttribute("todos",toDoServiceDB.findByDoneTrue());
        }
        return "activetodo";
    }

    @GetMapping(value = {"/todo/add"})
    public String showadd(Model model) {
        return "addtodo";
    }

    @PostMapping(value = {"/todo/add"})
    public String add(Model model, HttpServletRequest req) {
        Todo newTodo = new Todo();
        newTodo.setTitle(req.getParameter("addtitle"));
        newTodo.setDone(Boolean.parseBoolean(req.getParameter("adddone")));
        newTodo.setUrgent(Boolean.parseBoolean(req.getParameter("addurgent")));
        toDoServiceDB.save(newTodo);
        return "redirect:/mainpage";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(Model model, @PathVariable(value="id") long id) {
        toDoServiceDB.delete(id);
        return "redirect:/mainpage";
    }

    @PostMapping(value = "/search")
    public String search(Model model, HttpServletRequest req) {
        String result;
        Todo searchToDo = toDoServiceDB.searchByTitle(req.getParameter("titlesearch"));
        if(searchToDo != null) {
            result = "searchresult";
        } else {
            result = "redirect:/mainpage";
        }
        model.addAttribute("searchtodo", searchToDo);
        model.addAttribute("todos", toDoServiceDB.getAllTodos());
        return result;
    }

    @GetMapping(value = {"/todo/{id}/edit"})
    public String showEditoDo(Model model, @PathVariable(value="id") long id) {
        model.addAttribute("todo", toDoServiceDB.getToDo(id));
        return "edittodo";
    }

    @PostMapping(value = {"/todo/{id}/edit"})
    public String editTodo(Model model, @PathVariable(value="id") long id, HttpServletRequest req) {
        Todo needtoedittodo = toDoServiceDB.getToDo(id);
        Assignee willbeassigned = assigneeServiceDB.getAssignee(Long.parseLong(req.getParameter("assignhere")));

        needtoedittodo.setAssignee(willbeassigned);
        needtoedittodo.setTitle(req.getParameter("settitle"));
        needtoedittodo.setCreationTime(req.getParameter("setdate"));
        needtoedittodo.setDuedate(req.getParameter("setdue"));
        needtoedittodo.setDescription(req.getParameter("setdescription"));
        needtoedittodo.setDone(Boolean.parseBoolean(req.getParameter("setdone")));
        needtoedittodo.setUrgent(Boolean.parseBoolean(req.getParameter("seturgent")));

        toDoServiceDB.save(needtoedittodo);
        model.addAttribute("todo", toDoServiceDB.getToDo(id));

        return "redirect:/mainpage";
    }

    @GetMapping(value = {"/todo/{id}"})
    public String getTodo(Model model, @PathVariable(value="id") long id) {
        model.addAttribute("todo", toDoServiceDB.getToDo(id));
        return "tododetail";
    }
}
