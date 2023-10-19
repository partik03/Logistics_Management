package com.logistics.web.services.impl;

import com.logistics.web.models.Employee;
import com.logistics.web.services.EmployeeService;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class EmployeeServiceImpl implements EmployeeService {


    private JdbcTemplate jbdcTemplate;

    public EmployeeServiceImpl(DataSource ds){
        this.jbdcTemplate = new JdbcTemplate(ds);
    }


    @Override
   public List<Employee> findAllEmployees(){
        try{
            String sql = "SELECT * FROM Employee";

            RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
                @Override
                public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                    long EmployeeID = rs.getLong("EmployeeID");
                    String Contact = rs.getString("Contact");
                    String Role = rs.getString("Role");
                    String Name = rs.getString("Name");
                    return new Employee(EmployeeID, Contact, Role, Name);
                }
            };
//            ResultSetExtractor<Employee> extractor = new ResultSetExtractor<Employee>() {
//                @Override
//                public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
//                    if(rs.next()) {
//                        long EmployeeID = rs.getLong("EmployeeID");
//                        String Contact = rs.getString("Contact");
//                        String Role = rs.getString("Role");
//                        String Name = rs.getString("Name");
//                        return new Employee(EmployeeID, Contact, Role, Name);
//                    }
//                    return null;
//                }
//            };
            return jbdcTemplate.query(sql,rowMapper);

        }
        catch (SQLException err){
//            return err;
        }
    }

    @Override
    public Employee findEmployeeById(int id){
//        try{
           String sql = "SELECT * FROM EMPLOYEE WHERE EmployeeID=" + id;
           ResultSetExtractor<Employee> extractor = new ResultSetExtractor<Employee>() {
                @Override
                public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if(rs.next()) {
                        long EmployeeID = rs.getLong("EmployeeID");
                        String Contact = rs.getString("Contact");
                        String Role = rs.getString("Role");
                        String Name = rs.getString("Name");
                        return new Employee(EmployeeID, Contact, Role, Name);
                    }
                    return null;
                }
            };

           return jbdcTemplate.query(sql,extractor);

//        }

//        catch (SQLException err){
//
//        }
    }


    @Override
    public int createEmployee(String Contact,String Role, String Name){
        String sql = "INSERT INTO EMPLOYEE (Contact,Role,Name) VALUES (?,?,?)";
        return jbdcTemplate.update(sql,Contact,Role,Name);
    }

    @Override
    public int updateEmployee(String Contact,String Role, String Name,int id){
        String sql = "UPDATE EMPLOYEE SET Contac=?,Role=?,Name=? WHERE EmployeeID="+id;
        return jbdcTemplate.update(sql,Contact,Role,Name);
    }

    @Override
    public int
}
