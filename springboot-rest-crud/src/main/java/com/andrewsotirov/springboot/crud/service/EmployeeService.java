package com.andrewsotirov.springboot.crud.service;

import com.andrewsotirov.springboot.crud.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
