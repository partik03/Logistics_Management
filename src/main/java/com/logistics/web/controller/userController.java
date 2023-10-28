package com.logistics.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.logistics.web.dao.AuthenticationDao;
import com.logistics.web.dao.CarrierDao;
import com.logistics.web.dao.ComplaintDao;
import com.logistics.web.dao.InvoiceDao;
import com.logistics.web.dao.OrdersDao;
import com.logistics.web.dao.ProductDao;
import com.logistics.web.dao.ShipmentDao;
import com.logistics.web.dao.WarehouseDao;
import com.logistics.web.models.Complaint;
import com.logistics.web.models.Invoice;
import com.logistics.web.models.Orders;
import com.logistics.web.models.Product;
import com.logistics.web.services.impl.AuthenticationServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@Controller
public class userController {
    
    @Autowired
    public AuthenticationServiceImpl authenticationService;

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


    public userController(CarrierDao carrierDao,ComplaintDao complaintDao,InvoiceDao invoiceDao,OrdersDao orderDao,ShipmentDao shipmentDao,ProductDao productDao,AuthenticationDao authenticationDao,WarehouseDao warehouseDao) {
        this.carrierDao = carrierDao;
        this.complaintDao = complaintDao;
        this.invoiceDao = invoiceDao;
        this.orderDao = orderDao;
        this.shipmentDao = shipmentDao;
        this.productDao = productDao;
        this.authenticationDao = authenticationDao;
        this.warehouseDao = warehouseDao;
    }

    @GetMapping("/user/placeOrder")
    public String placeOrder(Model model){
        Orders order = new Orders();
        model.addAttribute("order", order);
        return "user_placeOrder";
    }
    @GetMapping("/user/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "user_addProduct";
    }
    @GetMapping("/user/orders")
    public String getUserOrders(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        int userId = authenticationService.handleGetUserIdByUsername(name);

        List<Orders> orders = orderDao.getAllOrdersByUserId(userId);
        model.addAttribute("orders", orders);
        return "user_orders";
    }

    @GetMapping("/user/products")
    public String getUserProducts(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        int userId = authenticationService.handleGetUserIdByUsername(name);

        List<Product> products = productDao.getAllProductsByUserId(userId);
        model.addAttribute("products", products);
        return "user_products";
    }

    @GetMapping("/user/complaints")
    public String getUserComplaints(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        int userId = authenticationService.handleGetUserIdByUsername(name);

        List<Complaint> complaints = complaintDao.getAllComplaintsByUserId(userId);
        model.addAttribute("complaints", complaints);
        return "user_complaints";
    }
    @GetMapping("/user/invoices")
    public String getUserInvoices(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        int userId = authenticationService.handleGetUserIdByUsername(name);

        List<Invoice> invoices = invoiceDao.getInvoiceByUserId(userId);
        model.addAttribute("invoices", invoices);
        return "user_invoices";
    }
    @GetMapping("/user/placeComplaint")
    public String placeComplaint(Model model){
        Complaint complaint = new Complaint();
        model.addAttribute("complaint", complaint);
        return "placeComplaint";
    }




    
    

}
