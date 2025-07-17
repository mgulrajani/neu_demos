package com.test.demo.repos;

import com.test.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


//deleted the impl of the Repo
//just extend your repo interface from JpaRepository

@Component
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
   List<Employee> findByName(String name);

    List<Employee> findByDept(String dept);
}