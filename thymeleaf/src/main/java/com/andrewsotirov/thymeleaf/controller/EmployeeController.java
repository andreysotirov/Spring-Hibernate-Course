package com.andrewsotirov.thymeleaf.controller;


import com.andrewsotirov.thymeleaf.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        Employee employee1 = new Employee(1, "andrew", "sotirov", "abv.bg@bg");
        Employee employee2 = new Employee(2, "tim", "buchi", "buchi.bg@bg");
        Employee employee3 = new Employee(3, "svetla", "sotirova", "svesve.bg@bg");

        employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);

        return "list-employees";
    }

}
