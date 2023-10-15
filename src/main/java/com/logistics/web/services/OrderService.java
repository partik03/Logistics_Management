package com.logistics.web.services;

import com.logistics.web.models.Order;

import java.util.List;

public interface OrderService {

    List<Order> listAllOrders();
    List<Order> listOrdersByCustomers(int customerId);

    Order createNewOrder(Order order);

    Order getOrderByOrderId(int orderId);

}
