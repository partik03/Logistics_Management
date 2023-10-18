package com.logistics.web.dao;

import com.logistics.web.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;


@Repository
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addEmployee(Employee employee){
        String sql = "INSERT INTO Employee(firstName,lastName,contact,role) VALUES(?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getContact());
            ps.setString(4,employee.getRole().name()); // role is an enum
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public Employee getEmployeeById(int id){
        String sql = "SELECT * FROM Employee WHERE empId ="+id;
        Employee employee= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class),id);
        return employee;
    }

    public List<Employee> getAllEmployees(){
        String sql = "SELECT * FROM Employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    public int deleteEmployeeById(int id){
        String sql = "DELETE FROM Employee WHERE empId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public Employee updateEmployeeById(Employee employee, int id){
        String sql = "UPDATE Employee SET firstName=?, lastName=?, contact=?, role=? WHERE empId = ?";
        jdbcTemplate.update(sql,employee.getFirstName(),employee.getLastName(),employee.getContact(),employee.getRole(),id);
        return employee;
    }
}