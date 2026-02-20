package com.studentManagementSystem.SMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.studentManagementSystem.SMS.entity.StudentInfo;
import com.studentManagementSystem.SMS.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "studentList";
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new StudentInfo());
        return "addStudent";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute StudentInfo student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        StudentInfo student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student"; 
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable String id, @ModelAttribute("student") StudentInfo student) {
        student.setId(id);   
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam("name") String name, Model model) {
        List<StudentInfo> students = studentService.searchByName(name);
        model.addAttribute("students", students);
        return "studentList";  
    }

}
