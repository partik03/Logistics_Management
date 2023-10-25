package com.logistics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminContoller {
    @GetMapping("/admin/dashboard")
    public String showDashboard(){
        return "dashboard"; 
    }
    @GetMapping("/admin/dashboard/customers")
    public String showDashboardCustomer(){
        return "dashboard_customers"; 
    }
    @GetMapping("/admin/dashboard/complaints")
    public String showDashboardComplaints(){
        return "dashboard_complaints"; 
    }
    @GetMapping("/admin/dashboard/employees")
    public String showDashboardEmployees(){
        return "dashboard_employees"; 
    }
    @GetMapping("/admin/dashboard/invoices")
    public String showDashboardInvoices(){
        return "dashboard_invoices"; 
    }
    @GetMapping("/admin/dashboard/orders")
    public String showDashboardOrders(){
        return "dashboard_orders"; 
    }
    @GetMapping("/admin/dashboard/products")
    public String showDashboardProducts(){
        return "dashboard_products"; 
    }
    @GetMapping("/admin/dashboard/shipments")
    public String showDashboardShipments(){
        return "dashboard_shipments"; 
    }
    @GetMapping("/admin/dashboard/warehouses")
    public String showDashboardWarehouses(){
        return "dashboard_warehouses"; 
    }
}
