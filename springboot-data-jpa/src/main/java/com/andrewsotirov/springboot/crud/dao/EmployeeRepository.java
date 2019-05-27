package com.andrewsotirov.springboot.crud.dao;

import com.andrewsotirov.springboot.crud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
