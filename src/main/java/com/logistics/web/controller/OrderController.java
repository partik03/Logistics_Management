package com.logistics.web.controller;

import com.logistics.web.models.Orders;
import com.logistics.web.services.impl.OrderServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class OrderController {
    public OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService){
        this.orderService = orderService;
    }

    @GetMapping("/order")
    @ResponseBody
    public List<Orders> getAllOrders(){
        return orderService.handleListAllOrders();
    }

    @GetMapping("/order/{id}")
    @ResponseBody
    public Orders getOrderById(@Valid @NotNull @PathVariable("id") int id){
        return orderService.handleGetOrderById(id);
    }

    @GetMapping("/orderuser/{id}")
    @ResponseBody
    public List<Orders> getOrderByUserId(@Valid @NotNull @PathVariable("id") int id){
        return orderService.handleListAllOrdersByUserId(id);
    }

    @GetMapping("/orderproduct/{id}")
    @ResponseBody
    public List<Orders> getOrderByProductId(@Valid @NotNull @PathVariable("id") int id){
        return orderService.handleListAllOrdersByProductId(id);
    }

    @GetMapping("/orderdate")
    @ResponseBody
    public List<Orders> getOrderByDate(@RequestParam(name = "low") Date low, @RequestParam(name = "high") Date high){
        System.out.println(low);
        System.out.println(high);
        return orderService.handleListAllOrdersByDate(low,high);
    }

    @PostMapping("/order")
    @ResponseBody
    public int addOrder(@Valid @NotNull @RequestBody Orders orders){
        return orderService.handleCreateNewOrder(orders);
    }

    @DeleteMapping("/order/{id}")
    @ResponseBody
    public int deleteOrderById(@Valid @NotNull @PathVariable("id") int id){
        return orderService.handleDeleteOrderId(id);
    }

    @PutMapping("/order/{id}")
    @ResponseBody
    public int updateOrderById(@Valid @NotNull @PathVariable("id") int id, @Valid @NotNull @RequestBody Orders orders){
        return orderService.handleUpdateOrderById(orders,id);
    }
}
