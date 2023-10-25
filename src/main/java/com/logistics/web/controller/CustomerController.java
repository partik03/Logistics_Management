package com.logistics.web.controller;

import com.logistics.web.dao.CustomerDao;
import com.logistics.web.models.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @PostMapping("/customer")
    @ResponseBody
    public int addCustomer(@Valid @NotNull @RequestBody Customer customer){
        return customerDao.addCustomer(customer);
    }

    @GetMapping("/customer")
    // @ResponseBody
    public String getAllCustomers(Model model) {
    List<Customer> customers = customerDao.getAllCustomers();
    model.addAttribute("customers", customers);
    System.out.println(customers);
    return "dashboard_customers";
}

    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer getCustomerById(@Valid @NotNull @PathVariable("id") int id){
        return customerDao.getCustomerById(id);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseBody
    public int deleteCustomerById(@Valid @NotNull @PathVariable("id") int id){
        return customerDao.deleteCustomerById(id);
    }

    @PutMapping("/customer/{id}")
    @ResponseBody
    public int updateCustomerById(@Valid @NotNull @PathVariable("id") int id, @Valid @NotNull @RequestBody Customer customer){
        return customerDao.updateCustomerById(customer, id);
    }

    @GetMapping("/user/orders")
    public String showUserOrders(){
        return "user_orders"; 
    }
    
    @GetMapping("/user/complaints")
    public String showUserComplaints(){
        return "user_complaints"; 
    }
    @GetMapping("/user/invoices")
    public String showUserInvoices(){
        return "user_invoices"; 
    }

    @GetMapping("/user/placeOrder")
    public String placeOrder(){
        return "placeOrder"; 
    }
    @GetMapping("/user/placeComplaint")
    public String placeComplaint(){
        return "placeComplaint"; 
    }
}
