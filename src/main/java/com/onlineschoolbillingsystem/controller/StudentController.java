package com.onlineschoolbillingsystem.controller;

import com.onlineschoolbillingsystem.entity.Student;
import com.onlineschoolbillingsystem.request.RegisterStudentRequest;
import com.onlineschoolbillingsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student registerStudent(@Valid @RequestBody RegisterStudentRequest registerStudentRequest) {
        return studentService.registerStudent(registerStudentRequest.getName(), registerStudentRequest.getAddress(),
                registerStudentRequest.getContact(), registerStudentRequest.getGender());
    }

}
