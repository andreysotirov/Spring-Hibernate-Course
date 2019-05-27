package com.andrewsotirov.rest;

import com.andrewsotirov.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<Student>();

        students.add(new Student("andrey", "sotirov"));
        students.add(new Student("tim", "dobrev"));
        students.add(new Student("svetlana", "sotirova"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId > students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student ID not found " + studentId);
        }

        return students.get(studentId);
    }

}
