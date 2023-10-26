 package com.logistics.web.services;

 import com.logistics.web.models.Order;

 import java.sql.Date;
 import java.util.List;

 public interface OrderService {

     public List<Order> handleListAllOrders();
     public List<Order> handleListAllOrdersByUserId(int id);
     public List<Order> handleListAllOrdersByProductId(int id);
     public List<Order> handleListAllOrdersByDate(Date low, Date high);
     public Order handleGetOrderById(int id);
     public int handleCreateNewOrder(Order order);
     public int handleUpdateOrderById(Order order, int id);
     public  int handleDeleteOrderId(int id);

 }
