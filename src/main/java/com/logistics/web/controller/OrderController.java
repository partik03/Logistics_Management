package com.logistics.web.controller;

import com.logistics.web.models.Order;
import com.logistics.web.repository.OrderRespository;
import com.logistics.web.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {

    public OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getAllOrders(){
        List<Order> orders = orderService.listAllOrders();
        return orders;
    }

    @GetMapping("/order/")
    public List<Order> getOrdersByCustomerId(@RequestParam String customerId){
        List<Order> orders = orderService.listOrdersByCustomers(Integer.parseInt(customerId));
        return orders;
    }

    @GetMapping("/order/")
    public Order getOrderByOrderId(@RequestParam String OrderId){
        Order order = orderService.getOrderByOrderId(Integer.parseInt(OrderId));
        return order;
    }

    @PostMapping("/order/new")
    public String createNeworder(@ModelAttribute("order") Order order){
        orderService.createNewOrder(order);
        return "redirect:/order";
    }


    @PatchMapping("/order/update")
    public String editOrder(@RequestParam("oid") String OrderId)







}
