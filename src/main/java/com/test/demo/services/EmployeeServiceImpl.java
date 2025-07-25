package com.test.demo.services;


import com.test.demo.entities.Employee;
import com.test.demo.repos.EmployeeJDBCRepo;
import com.test.demo.repos.EmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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



    @Autowired
    private EmployeeJDBCRepo jdbcRepo;


    @Transactional
    @Override
    public Employee addEmployee(Employee e) {
        return repo.save(e);
    }


    @Transactional
    @Override
    public Employee updateEmployee(Long id, Employee e) throws    EntityNotFoundException {
        //find the employee by id
        Employee existingEmployee = repo.findById(id).orElseThrow(EntityNotFoundException::new);
        if (existingEmployee != null) {
            existingEmployee.setName(e.getName());
            existingEmployee.setDept(e.getDept());
            existingEmployee.setSalary(e.getSalary());
            return repo.save(existingEmployee);
        }
        return null; // or throw an exception if not found
    }

    @Override
    public List<Employee> listAllEmployees() {
       return repo.findAll();

    }

    @Override
    public Employee findEmployeeById(Long id) throws  EntityNotFoundException {
        return repo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteEmployeeById(Long id) {

    }

    @Override
    public List<Employee> findByName(String name) {
        return List.of();
    }

    @Override
    public List<Employee> findByDept(String dept) {
        return List.of();
    }

    @Override
    public List<Employee> findBySalary(Double salary) {
        return List.of();
    }

    @Override
    public List<Employee> findByNameAndDept(String name, String dept) {
        return List.of();
    }

    @Transactional
    @Override
    public Employee addEmployeejdbc(Employee e) {
        System.out.println("Adding employee using JDBC: inservice " + e);

        return jdbcRepo.save(e);

    }
}