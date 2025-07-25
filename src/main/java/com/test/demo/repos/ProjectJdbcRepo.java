package com.test.demo.repos;
import com.test.demo.entities.Project;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository

public interface ProjectJdbcRepo {
    // Define methods for CRUD operations using JDBC
    // For example:
    Project save(Project project);
    Project findById(Long id);
    List<Project> findAll();
    Project deleteById(Long id);
    List<Project> findByName(String name);
    List<Project> findByStartDate(LocalDate startDate);
    List<Project> findByEmployeeId(Long employeeId);

     Map<String, Integer> getEmployeeCountPerProject();

}
