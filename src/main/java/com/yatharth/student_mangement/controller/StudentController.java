package com.yatharth.student_mangement.controller;

import com.yatharth.student_mangement.model.Student;
import com.yatharth.student_mangement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    // Home page – shows list of students
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", service.listAll());
        return "index";                    // → templates/index.html
    }

    // Show "Add New Student" form
    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "new_student";             
    }

    // Save student (Add or Update)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.save(student);
        return "redirect:/";               // go back to home page
    }

    // Show Edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", service.get(id));
        return "edit_student";             // → templates/edit_student.html
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}