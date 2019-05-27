package com.andrewsotirov.springboot.crud.dao;

import com.andrewsotirov.springboot.crud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
