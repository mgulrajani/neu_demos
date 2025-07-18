package com.test.demo.repos;

import com.test.demo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> {
    // Custom query to find projects by employee ID
    // This method will return a list of projects associated with a specific employee ID
    // The method name is derived from the entity field names
    @Query("SELECT p FROM Project p JOIN p.employees e WHERE e.id = ?1")

    List<Project> findByEmployeesId(Long employeeId);
}
