package com.logistics.web.services.impl;

import com.logistics.web.models.Order;
import com.logistics.web.repository.CustomerRepository;
import com.logistics.web.repository.OrderRespository;
import com.logistics.web.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceimpl implements OrderService {


    public OrderRespository orderRepository;
    @Autowired
    public OrderServiceimpl(OrderRespository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> listAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public List<Order> listOrdersByCustomers(int customerId){
        List<Order> orders = orderRepository.findAllByCustomerID(customerId);
        return orders;
    }

    @Override
    public Order createNewOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderByOrderId(int orderId){
        Order order = orderRepository.findByOrderID(orderId);
        return order;
    }


}
