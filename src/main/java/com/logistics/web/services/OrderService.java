 package com.logistics.web.services;

 import com.logistics.web.models.Order;

 import java.util.Date;
 import java.util.List;

 public interface OrderService {

     public List<Order> handleListAllOrders();
     public List<Order> handleListOrdersByCustomerId(int customerId);

     public Order handleGetOrderById(int id);

     public int handleCreateNewOrder(Order order);

     public int handleUpdateOrderById(Order order, int id);

     public  int handleDeleteOrderId(int id);


     public Order modifyOrderStatus(int orderId,String status);


     public Order getOrderByOrderId(int orderId);

     public List<Order> filterOrdersByData(Date date);


     public List<Order> filterByStatus(String status);

//     List<Order>

 }
