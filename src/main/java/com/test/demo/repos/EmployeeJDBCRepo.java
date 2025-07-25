package com.test.demo.repos;

import com.test.demo.entities.Employee;

import java.util.List;

public interface EmployeeJDBCRepo {

    // Define methods for CRUD operations using JDBC
    // For example:
     Employee save(Employee employee);
     Employee findById(Long id);
     List<Employee> findAll();
     Employee deleteById(Long id);
     List<Employee> findByName(String name);
     List<Employee> findByDept(String dept);
    List<Employee> findBySalary(Double salary);
    List<Employee> findByNameAndDept(String name, String dept);


}
