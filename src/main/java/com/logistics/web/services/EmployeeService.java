package com.logistics.web.services;

import com.logistics.web.models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();


    Employee findEmployeeById(int id);

    int createEmployee( String Contact,String Role, String Name );

    int updateEmployee(String Contact,String Role, String Name,int id);

    int deleteEmployee(int id);


}
