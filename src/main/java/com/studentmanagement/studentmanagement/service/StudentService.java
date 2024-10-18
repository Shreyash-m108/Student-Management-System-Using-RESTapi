package com.studentmanagement.studentmanagement.service;

import com.studentmanagement.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void addStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudent(Long id);
}
