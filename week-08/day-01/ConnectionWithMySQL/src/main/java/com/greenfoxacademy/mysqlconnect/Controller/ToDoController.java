package com.greenfoxacademy.mysqlconnect.Controller;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import com.greenfoxacademy.mysqlconnect.Model.Todo;
import com.greenfoxacademy.mysqlconnect.Service.AssigneeServiceDBImpl;
import com.greenfoxacademy.mysqlconnect.Service.ToDoServiceDBImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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
        needtoedittodo.setCreation_time(req.getParameter("setdate"));
        needtoedittodo.setDone(Boolean.parseBoolean(req.getParameter("setdone")));
        needtoedittodo.setUrgent(Boolean.parseBoolean(req.getParameter("seturgent")));

        toDoServiceDB.save(needtoedittodo);
        model.addAttribute("todo", toDoServiceDB.getToDo(id));

        return "redirect:/mainpage";
    }

    @GetMapping(value = "/assigneelist")
    public String showList(Model model) {
        return "assigneelist";
    }

    @PostMapping(value = "/{id}/removeassignee")
    public String removeAssignee(Model model, @PathVariable(value="id") long id) {
        assigneeServiceDB.delete(id);
        return "redirect:/assigneelist";
    }

    @GetMapping(value = {"/assignee/{id}/edit"})
    public String showEdiAssignee(Model model, @PathVariable(value="id") long id) {
        model.addAttribute("ass", assigneeServiceDB.getAssignee(id));
        return "editassignee";
    }

    @PostMapping(value = {"/assignee/{id}/edit"})
    public String editAssignee(Model model, @PathVariable(value="id") long id, HttpServletRequest req) {
        Assignee needToEditAssignee = assigneeServiceDB.getAssignee(id);
        needToEditAssignee.setName(req.getParameter("setname"));
        needToEditAssignee.setEmail(req.getParameter("setemail"));
        assigneeServiceDB.save(needToEditAssignee);
        model.addAttribute("ass", assigneeServiceDB.getAssignee(id));
        return "redirect:/assigneelist";
    }

    @GetMapping(value = {"/assignee/add"})
    public String showaddAssignee(Model model) {
        return "addassignee";
    }

    @PostMapping(value = {"/assignee/add"})
    public String addAssignee(Model model, HttpServletRequest req) {
        Assignee newAssignee = new Assignee();
        newAssignee.setName(req.getParameter("addname"));
        newAssignee.setEmail(req.getParameter("addemail"));
        assigneeServiceDB.save(newAssignee);
        return "redirect:/assigneelist";
    }
}
