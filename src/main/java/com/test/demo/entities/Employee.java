package com.test.demo.entities;


//1.to create ENtity  --done
//2. configure persistent unit   -- persistence.xml  --configuration file  , where
//3. entitymanager which will manage entities  -c-rud  -


import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

//JPA to persist this java object
//mandatory  --@Entity and @Id
@Entity //by default what will be the table
@Component
public class Employee {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(dept, employee.dept) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dept, salary);
    }

    @Id  //mandatory
   @GeneratedValue(strategy = GenerationType.AUTO)  //not mandatory

    private Long id;

    private String name;   //findByName

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    private String dept;   //findByDept
    private Double salary;  //findBySalary

    @Autowired

    @OneToOne
    private Address address;


    /*@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private Project project;
*/

    //here we are showing the association of Employee with Project
    //ManyToMany
    //Employee to be secondary , Project to be primary ,that's why mappedBy
    @ManyToMany(mappedBy = "employees",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Project> projects;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(Long id, String name, String dept, Double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public Employee(String name, String dept, Double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}