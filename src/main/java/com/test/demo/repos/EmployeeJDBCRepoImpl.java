package com.test.demo.repos;

import com.test.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
@Repository
public class EmployeeJDBCRepoImpl implements EmployeeJDBCRepo{
    // This class would implement the methods defined in EmployeeJDBCRepo interface
    // and use JDBC to interact with the database.
//autowrire jdbctemplate

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee save(Employee employee) {
        // Implement JDBC logic to save the employee
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO employee (name, dept, salary) VALUES (?, ?, ?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDept());
            ps.setBigDecimal(3, new BigDecimal(employee.getSalary()));
            return ps;
        }, keyHolder);

        Number id = keyHolder.getKey();
        System.out.println("Inserted employee ID: " + id);
        employee.setId(id.longValue()); // Assuming Employee has a setId method
        System.out.println("repo layer "+employee);
        return employee; // Return the saved employee with the generated ID

    }
    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Employee deleteById(Long id) {
        return null;
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
}
