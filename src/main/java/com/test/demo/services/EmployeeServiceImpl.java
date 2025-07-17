package com.test.demo.services;


import com.test.demo.entities.Employee;
import com.test.demo.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeServiceImpl implements  EmployeeService{

  //we are just declaring the dependent object
    //EmployeeService is going to consume EmployeeRepo object which is autowired here
    //Spring framework will provide it

    @Autowired
    private EmployeeRepo repo;

    @Override
    public Employee addEmployee(Employee e) {
        return null;
    }

    @Override
    public Employee updateEmployee(Long id, Employee e) {
        return null;
    }

    @Override
    public List<Employee> listAllEmployees() {
       return repo.findAll();

    }

    @Override
    public Employee findEmployeeById(Long id) {
        return null;
    }
}