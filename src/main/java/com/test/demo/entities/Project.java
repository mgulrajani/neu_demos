package com.test.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
@Entity
public class Project {


@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private Long  id;
    private String name;
    private LocalDate startDate;
   //ManyTOMany


   /* @OneToOne
    private Employee  employee;
*/

    @ManyToMany
    private Set<Employee> employees;

    public Project(Long id, String name, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public Project(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    //const  ructors

    //getters and setters


    //toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id && Objects.equals(name, project.name) && Objects.equals(startDate, project.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate);
    }



}