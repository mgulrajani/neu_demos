package com.test.demo.repos;

import com.test.demo.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectJdbcRepoImpl implements  ProjectJdbcRepo {

    //autowire JdbcTemplate or any other JDBC utility here if needed
    @Autowired
    private JdbcTemplate jdbcTemplate;

       //autowire NamedParameterJdbcTemplate

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public Project findById(Long id) {
        return null;
    }

    @Override
    public List<Project> findAll() {
        return List.of();
    }

    @Override
    public Project deleteById(Long id) {
        return null;
    }

    @Override
    public List<Project> findByName(String name) {
        return List.of();
    }

    @Override
    public List<Project> findByStartDate(LocalDate startDate) {
        return List.of();
    }

    @Override
    public List<Project> findByEmployeeId(Long employeeId) {
        return List.of();
    }


    public Map<String, Integer> getEmployeeCountPerProject() {
        String sql = "SELECT p.name, COUNT(e.id) AS employee_count " +
                "FROM project p " +
                "LEFT JOIN project_employees ep ON p.id = ep.projects_id " +
                "LEFT JOIN employee e ON ep.employees_id = e.id " +
                "GROUP BY p.name";

        return namedParameterJdbcTemplate.query(sql, rs -> {
            Map<String, Integer> result = new LinkedHashMap<>();
            while (rs.next()) {
                result.put(rs.getString("name"), rs.getInt("employee_count"));
            }
            return result;
        });
    }

}
