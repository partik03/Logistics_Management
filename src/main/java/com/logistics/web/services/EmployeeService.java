package com.logistics.web.services;

import com.logistics.web.models.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> handleGetAllEmployees();


    public Employee handleGetEmployeeById(int id);

    public int handleAddEmployee( Employee employee );

    public int handleUpdateEmployeeById(Employee employee,int id);

    public int handleDeleteEmployeeById(int id);


}
