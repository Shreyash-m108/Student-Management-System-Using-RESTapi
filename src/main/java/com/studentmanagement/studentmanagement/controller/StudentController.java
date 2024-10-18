package com.studentmanagement.studentmanagement.controller;

import com.studentmanagement.studentmanagement.entity.Student;
import com.studentmanagement.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "showstudents";
    }

    @GetMapping("/students/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addstudent";
    }


    @PostMapping("/students/save")
    public String saveStudent(Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String updateStudent(@PathVariable long id,Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "updatestudent";
    }

    @PostMapping("/students/saveupdate/{id}")
    public String saveUpdate(@PathVariable long id,
            @ModelAttribute("student") Student student,
                             Model model) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());
        existingStudent.setGender(student.getGender());
        existingStudent.setCity(student.getCity());
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }



}
