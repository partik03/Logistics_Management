 package com.logistics.web.services;

 import com.logistics.web.models.Orders;

 import java.sql.Date;
 import java.util.List;

 public interface OrderService {

     public List<Orders> handleListAllOrders();
     public List<Orders> handleListAllOrdersByUserId(int id);
     public List<Orders> handleListAllOrdersByProductId(int id);
     public List<Orders> handleListAllOrdersByDate(Date low, Date high);
     public Orders handleGetOrderById(int id);
     public int handleCreateNewOrder(Orders orders);
     public int handleUpdateOrderById(Orders orders, int id);
     public  int handleDeleteOrderId(int id);

 }
