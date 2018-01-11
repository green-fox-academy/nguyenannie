package com.greenfoxacademy.classapp.Controller;

import com.greenfoxacademy.classapp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClassController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/gfa")
    public String showMainPage(Model model) {
        studentService.count();
        model.addAttribute("student", studentService);
        return "gfa";
    }

    @RequestMapping(value = "/gfa/list")
    public String showStudentList(Model model) {
        model.addAttribute("studentList", studentService.findAll());
        return "StudentList";
    }

    @RequestMapping(value = "/gfa/save")
    public String addStudent(Model model, @RequestParam(value = "studentname") String studentname) {
        studentService.save(studentname);
        model.addAttribute("student", studentService);
        return "savepage";
    }

    @RequestMapping(value = "/gfa/add")
    public String addStudent(Model model) {
        return "addform";
    }

    @RequestMapping(value = "/gfa/check")
    public String checkStudent(Model model, @RequestParam(value = "studentname", required = false) String studentname) {
        studentService.checkName(studentname);
        model.addAttribute("student", studentService);
        model.addAttribute("inList", studentService.isInList());
        return "checkpage";
    }
}
