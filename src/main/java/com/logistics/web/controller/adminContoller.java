package com.logistics.web.controller;

import com.logistics.web.dao.*;
import com.logistics.web.models.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

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
        shipments.forEach(shipment -> {
            if (shipment.getCarrierId() == 1) {
                shipment.setCarrierId(0);
            }
            if(shipment.getWarehouseId() == 1){
                shipment.setWarehouseId(0);
            }
        });
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
        User customer=new User();
        model.addAttribute("customer",customer);
        return "dashboard_addCustomer"; 
    }
    @GetMapping("/admin/updateCustomer/{id}")
    public String updateCustomer(@Valid @NotNull @PathVariable("id") int id,Model model){
        User customer = authenticationDao.getUserById(id);
        model.addAttribute("customer", customer);
        return "dashboard_updateCustomer"; 
    }

    @GetMapping("/admin/addEmployee")
    public String addEmployee(Model model){
        User employee =new User();
        model.addAttribute("employee",employee);
        return "dashboard_addEmployee"; 
    }
    @GetMapping("/admin/updateEmployee/{id}")
    public String updateEmployee(@Valid @NotNull @PathVariable("id") int id,Model model){
        User employee = authenticationDao.getUserById(id);
        model.addAttribute("employee", employee);
        return "dashboard_updateEmployee"; 
    }

    @GetMapping("/admin/addComplaint")
    public String addComplaint(Model model){
        Complaint complaint =new Complaint();
        model.addAttribute("complaint",complaint);
        return "dashboard_addComplaint"; 
    }
    @GetMapping("/admin/updateComplaint/{id}")
    public String updateComplaint(@Valid @NotNull @PathVariable("id") int id,Model model){
        Complaint complaint = complaintDao.getComplaintById(id);
        model.addAttribute("complaint", complaint);
        return "dashboard_updateComplaint"; 
    }

    @GetMapping("/admin/addInvoice")
    public String addInvoice(Model model){
        Invoice invoice =new Invoice();
        model.addAttribute("invoice",invoice);
        return "dashboard_addInvoice"; 
    }
    @GetMapping("/admin/updateInvoice/{id}")
    public String updateInvoice(@Valid @NotNull @PathVariable("id") int id,Model model){
        Invoice invoice = invoiceDao.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "dashboard_updateInvoice"; 
    }


    @GetMapping("/admin/addOrder")
    public String addOrder(Model model){
        Orders order =new Orders();
        model.addAttribute("order",order);
        return "dashboard_addOrder"; 
    }
    @GetMapping("/admin/updateOrder/{id}")
    public String updateOrder(@Valid @NotNull @PathVariable("id") int id,Model model){
        Orders order = orderDao.getOrderById(id);
        model.addAttribute("order", order);
        return "dashboard_updateOrder"; 
    }

    @GetMapping("/admin/addProduct")
    public String addProduct(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        return "dashboard_addProduct"; 
    }
    @GetMapping("/admin/updateProduct/{id}")
    public String updateProduct(@Valid @NotNull @PathVariable("id") int id,Model model){
        Product product = productDao.getProductById(id);
        model.addAttribute("product", product);
        return "dashboard_updateProduct"; 
    }
    @GetMapping("/admin/addCarrier")
    public String addCarrier(Model model){
        Carrier carrier =new Carrier();
        model.addAttribute("carrier",carrier);
        return "dashboard_addCarrier"; 
    }
    @GetMapping("/admin/updateCarrier/{id}")
    public String updateCarrier(@Valid @NotNull @PathVariable("id") int id,Model model){
        Carrier carrier = carrierDao.getCarrierById(id);
        model.addAttribute("carrier", carrier);
        return "dashboard_updateCarrier"; 
    }

    @GetMapping("/admin/addShipment")
    public String addShipment(Model model){
        Shipment shipment =new Shipment();
        model.addAttribute("shipment",shipment);
        return "dashboard_addShipment"; 
    }
    @GetMapping("/admin/updateShipment/{id}")
    public String updateShipment(@Valid @NotNull @PathVariable("id") int id,Model model){
        Shipment shipment = shipmentDao.getShipmentById(id);
        model.addAttribute("shipment", shipment);
        return "dashboard_updateShipment"; 
    }

    @GetMapping("/admin/addWarehouse")
    public String addWarehouse(Model model){
        Warehouse warehouse =new Warehouse();
        model.addAttribute("warehouse",warehouse);
        return "dashboard_addWarehouse"; 
    }
    @GetMapping("/admin/updateWarehouse/{id}")
    public String updateWarehouse(@Valid @NotNull @PathVariable("id") int id,Model model){
        Warehouse warehouse = warehouseDao.getWarehouseById(id);
        model.addAttribute("warehouse", warehouse);
        return "dashboard_updateWarehouse"; 
    }
}
