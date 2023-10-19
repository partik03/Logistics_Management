 package com.logistics.web.services;

 import com.logistics.web.models.Order;

 import java.util.Date;
 import java.util.List;

 public interface OrderService {

     List<Order> listAllOrders();
     List<Order> listOrdersByCustomerId(int customerId);

     Order createNewOrder(Order order);

     Order modifyOrderStatus(int orderId,String status);

     Order getOrderByOrderId(int orderId);

     List<Order> filterOrdersByData(Date date);


     List<Order> filterByStatus(String status);

//     List<Order>

 }
