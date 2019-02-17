package com.greenfoxacademy.greenfoxclass.controllers;

import com.greenfoxacademy.greenfoxclass.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/gfa")
  public String show(Model model) {
    model.addAttribute("count", studentService.count());
    return "main";
  }

  @GetMapping("/gfa/list")
  public String showStudents(Model model) {
    model.addAttribute("studentNames", studentService.findAll());
    return "displaystudents";
  }

  @GetMapping("/gfa/add")
  public String addStudentForm() {
    return "addstudentform";
  }

  @GetMapping("/gfa/save")
  public String addStudentSubmit(@RequestParam String name, Model model) {
    studentService.save(name);
    return "redirect:/gfa/list";
  }

  @GetMapping("/gfa/check")
  public String checkStudentForm() {
    return "checkstudentform";
  }

  @PostMapping("/gfa/check")
  public String checkStudentSubmit(@RequestParam String name, Model model) {
    boolean isInTheClass = studentService.checkThisName(name);
    model.addAttribute("isInTheClass", isInTheClass);
    model.addAttribute("name", name);
    return "checkstudentform";
  }

}
