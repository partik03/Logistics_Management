package com.logistics.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.logistics.web.dao.CarrierDao;
import com.logistics.web.dao.ComplaintDao;
import com.logistics.web.dao.CustomerDao;
import com.logistics.web.dao.InvoiceDao;
import com.logistics.web.dao.OrderDao;
import com.logistics.web.dao.ProductDao;
import com.logistics.web.dao.ShipmentDao;
import com.logistics.web.dao.UserDao;
import com.logistics.web.dao.WarehouseDao;
import com.logistics.web.models.Complaint;
import com.logistics.web.models.Customer;
import com.logistics.web.models.Employee;
import com.logistics.web.models.Invoice;
import com.logistics.web.models.Order;
import com.logistics.web.models.Product;
import com.logistics.web.models.Shipment;
import com.logistics.web.models.User;
import com.logistics.web.models.Warehouse;

@Controller
public class adminContoller {

    @Autowired
    private final CarrierDao carrierDao;
    @Autowired
    private final ComplaintDao complaintDao;
    @Autowired
    private final InvoiceDao invoiceDao;
    @Autowired
    private final OrderDao orderDao;
    @Autowired
    private final ShipmentDao shipmentDao;
    @Autowired
    private final ProductDao productDao;
    @Autowired
    private final UserDao userDao;
    @Autowired
    private final WarehouseDao warehouseDao;
    

    public adminContoller(CarrierDao carrierDao,ComplaintDao complaintDao,InvoiceDao invoiceDao,OrderDao orderDao,ShipmentDao shipmentDao,ProductDao productDao,UserDao userDao,WarehouseDao warehouseDao) {
        this.carrierDao = carrierDao;
        this.complaintDao = complaintDao;
        this.invoiceDao = invoiceDao;
        this.orderDao = orderDao;
        this.shipmentDao = shipmentDao;
        this.productDao = productDao;
        this.userDao = userDao;
        this.warehouseDao = warehouseDao;
    }


    @GetMapping("/admin/dashboard")
    public String showDashboard(){
        return "dashboard"; 
    }
    @GetMapping("/admin/dashboard/customers")
    public String showDashboardCustomer(Model model){
        List<User> customers = userDao.getAllUsers();
        model.addAttribute("customers",customers);
        return "dashboard_customers"; 
    }
    @GetMapping("/admin/dashboard/complaints")
    public String showDashboardComplaints(Model model){
        List<Complaint> complaints = complaintDao.getAllComplaints();
        model.addAttribute("complaints", complaints);
        return "dashboard_complaints"; 
    }
    
    @GetMapping("/admin/dashboard/employees")
    public String showDashboardEmployees(){
        // List<Employee> employees = emplo
        return "dashboard_employees"; 
    }
    @GetMapping("/admin/dashboard/invoices")
    public String showDashboardInvoices(Model model){
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        model.addAttribute("invoices", invoices);
        return "dashboard_invoices"; 
    }
    @GetMapping("/admin/dashboard/orders")
    public String showDashboardOrders(Model model){
        List<Order> orders = orderDao.getAllOrders();
        model.addAttribute("orders", orders);
        return "dashboard_orders"; 
    }
    @GetMapping("/admin/dashboard/products")
    public String showDashboardProducts(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "dashboard_products"; 
    }
    @GetMapping("/admin/dashboard/shipments")
    public String showDashboardShipments(Model model){
        List<Shipment> shipments = shipmentDao.getAllShipments();
        model.addAttribute("shipments", shipments);
        return "dashboard_Shipments"; 
    }
    @GetMapping("/admin/dashboard/warehouses")
    public String showDashboardWarehouses(Model model){
        List<Warehouse> warehouses = warehouseDao.getAllWarehouses();
        model.addAttribute("warehouses", warehouses);
        return "dashboard_warehouses"; 
    }
}
