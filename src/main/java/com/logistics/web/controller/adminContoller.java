package com.logistics.web.controller;

import com.logistics.web.dao.*;
import com.logistics.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class adminContoller {

    @Autowired
    private final CarrierDao carrierDao;
    @Autowired
    private final ComplaintDao complaintDao;
    @Autowired
    private final InvoiceDao invoiceDao;
    @Autowired
    private final OrdersDao orderDao;
    @Autowired
    private final ShipmentDao shipmentDao;
    @Autowired
    private final ProductDao productDao;
    @Autowired
    private final AuthenticationDao authenticationDao;
    @Autowired
    private final WarehouseDao warehouseDao;


    public adminContoller(CarrierDao carrierDao,ComplaintDao complaintDao,InvoiceDao invoiceDao,OrdersDao orderDao,ShipmentDao shipmentDao,ProductDao productDao,AuthenticationDao authenticationDao,WarehouseDao warehouseDao) {
        this.carrierDao = carrierDao;
        this.complaintDao = complaintDao;
        this.invoiceDao = invoiceDao;
        this.orderDao = orderDao;
        this.shipmentDao = shipmentDao;
        this.productDao = productDao;
        this.authenticationDao = authenticationDao;
        this.warehouseDao = warehouseDao;
    }


    @GetMapping("/admin/dashboard")
    public String showDashboard(){
        return "dashboard_customers"; 
    }
    @GetMapping("/admin/dashboard/customers")
    public String showDashboardCustomer(Model model){
        List<User> customers = authenticationDao.getAllCustomers();
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
    public String showDashboardEmployees(Model model){
        List<User> Employees = authenticationDao.getAllEmployees();
        model.addAttribute("employees",Employees);
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
        List<Orders> orders = orderDao.getAllOrders();
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
        return "dashboard_shipments"; 
    }
    @GetMapping("/admin/dashboard/carriers")
    public String showDashboardCarriers(Model model){
        List<Carrier> carriers = carrierDao.getAllCarriers();
        model.addAttribute("carriers", carriers);
        return "dashboard_carriers"; 
    }
    @GetMapping("/admin/dashboard/warehouses")
    public String showDashboardWarehouses(Model model){
        List<Warehouse> warehouses = warehouseDao.getAllWarehouses();
        model.addAttribute("warehouses", warehouses);
        System.out.println(warehouses);
        return "dashboard_warehouses";
    }
    
    
    @GetMapping("/admin/addCustomer")
    public String addCustomer(Model model){
        return "dashboard_addCustomer"; 
    }
    @GetMapping("/admin/addEmployee")
    public String addEmployee(Model model){
        return "dashboard_addEmployee"; 
    }
    @GetMapping("/admin/addComplaint")
    public String addComplaint(Model model){
        return "dashboard_addComplaint"; 
    }
    @GetMapping("/admin/addInvoice")
    public String addInvoice(Model model){
        return "dashboard_addInvoice"; 
    }
    @GetMapping("/admin/addOrder")
    public String addOrder(Model model){
        return "dashboard_addOrder"; 
    }
    @GetMapping("/admin/addProduct")
    public String addProduct(Model model){
      

        Product product=new Product();
        model.addAttribute("product",product);

        return "dashboard_addProduct"; 
    }
    @GetMapping("/admin/updateProduct")
    public String updateProduct(@PathVariable(value = "id") int id,Model model){
        Product product = productDao.getProductById(id);
        model.addAttribute("product", product);
        return "dashboard_updateProduct"; 
    }
    @GetMapping("/admin/addCarrier")
    public String addCarrier(Model model){
        return "dashboard_addCarrier"; 
    }
    @GetMapping("/admin/addShipment")
    public String addShipment(Model model){
        return "dashboard_addShipment"; 
    }
    @GetMapping("/admin/addWarehouse")
    public String addWarehouse(Model model){
        return "dashboard_addWarehouse"; 
    }
}
