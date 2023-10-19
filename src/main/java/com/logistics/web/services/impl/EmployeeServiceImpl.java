 package com.logistics.web.services.impl;

 import com.logistics.web.dao.EmployeeDao;
 import com.logistics.web.models.Employee;
 import com.logistics.web.services.EmployeeService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import java.util.List;

 @Service
 public abstract class EmployeeServiceImpl implements EmployeeService {


     public EmployeeDao employeeDao;

     @Autowired
     public EmployeeServiceImpl(EmployeeDao employeeDao){
         this.employeeDao = employeeDao;
     }


     public List<Employee> handleGetAllEmployees(){
         return employeeDao.getAllEmployees();
     }


     public Employee handleGetEmployeeById(int id){
         return employeeDao.getEmployeeById(id);
     }

     public int handleAddEmployee( Employee employee ){
         return employeeDao.addEmployee(employee);
     }

     public int handleUpdateEmployeeById(Employee employee,int id){
         return employeeDao.updateEmployeeById(employee,id);
     }

     public int handleDeleteEmployeeById(int id){
         return employeeDao.deleteEmployeeById(id);
     }

 }
