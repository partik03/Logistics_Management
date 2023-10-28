package com.logistics.web.controller;

import com.logistics.web.models.Orders;
import com.logistics.web.services.impl.OrdersServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class OrdersController {
    public OrdersServiceImpl orderService;

    @Autowired
    public OrdersController(OrdersServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    @ResponseBody
    public List<Orders> getAllOrder() {
        return orderService.handleListAllOrder();
    }

    @GetMapping("/order/{id}")
    @ResponseBody
    public Orders getOrderById(@Valid @NotNull @PathVariable("id") int id) {
        return orderService.handleGetOrderById(id);
    }

    @GetMapping("/orderuser/{id}")
    @ResponseBody
    public List<Orders> getOrderByUserId(@Valid @NotNull @PathVariable("id") int id) {
        return orderService.handleListAllOrderByUserId(id);
    }

    @GetMapping("/orderproduct/{id}")
    @ResponseBody
    public List<Orders> getOrderByProductId(@Valid @NotNull @PathVariable("id") int id) {
        return orderService.handleListAllOrderByProductId(id);
    }

    @GetMapping("/orderdate")
    @ResponseBody
    public List<Orders> getOrderByDate(@RequestParam(name = "low") Date low, @RequestParam(name = "high") Date high) {
        System.out.println(low);
        System.out.println(high);
        return orderService.handleListAllOrderByDate(low, high);
    }

    @PostMapping("/order")
    public String addOrder(@ModelAttribute Orders orders) {
        orderService.handleCreateNewOrder(orders);
        return "redirect:/admin/dashboard/orders";
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrderById(@Valid @NotNull @PathVariable("id") int id) {
        orderService.handleDeleteOrderId(id);
        return "redirect:/admin/dashboard/orders";

    }

    @PutMapping("/order/{id}")
    public String updateOrderById(@Valid @NotNull @PathVariable("id") int id,
            @ModelAttribute Orders orders) {
        orderService.handleUpdateOrderById(orders, id);
        return "redirect:/admin/dashboard/orders";

    }
}
