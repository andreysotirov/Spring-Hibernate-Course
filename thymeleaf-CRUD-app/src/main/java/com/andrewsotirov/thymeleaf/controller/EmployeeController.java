package com.andrewsotirov.thymeleaf.controller;


import com.andrewsotirov.thymeleaf.entity.Employee;
import com.andrewsotirov.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/addForm")
    public String addForm(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/form-employee";
    }

    @GetMapping("/updateForm")
    public String showUpdateForm(@RequestParam("employeeId") int id, Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employees/form-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@ModelAttribute("employeeId") int id) {

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }


}
