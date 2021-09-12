package com.supremecorp.springsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by suprememajor on the 9/12/21
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private static final List<Student> STUDENT = Arrays.asList(new Student(1, "James Meyers"), new Student(2, "Nobert Sama"), new Student(3, "Alan Walker"));

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENT.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student with Id: " + studentId + " does not exist"));
    }
}
