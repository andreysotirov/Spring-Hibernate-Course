package com.andrewsotirov.thymeleaf.dao;

import com.andrewsotirov.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAsc();


}
