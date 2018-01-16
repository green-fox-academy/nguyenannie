package com.greenfoxacademy.mysqlconnect.Controller;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import com.greenfoxacademy.mysqlconnect.Model.Todo;
import com.greenfoxacademy.mysqlconnect.Service.AssigneeServiceDBImpl;
import com.greenfoxacademy.mysqlconnect.Service.ToDoServiceDBImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AssigneeController {

    private final
    ToDoServiceDBImpl toDoServiceDB;

    private final
    AssigneeServiceDBImpl assigneeServiceDB;

    @Autowired
    public AssigneeController(ToDoServiceDBImpl toDoServiceDB, AssigneeServiceDBImpl assigneeServiceDB) {
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

    @GetMapping(value = {"/assignee/{id}"})
    public String getAssignee(Model model, @PathVariable(value="id") long id) {
        model.addAttribute("assignee", assigneeServiceDB.getAssignee(id));
        return "assigneedetail";
    }
}
