 package com.logistics.web.services;

 import com.logistics.web.models.Orders;

 import java.sql.Date;
 import java.util.List;

 public interface OrdersService {

     public List<Orders> handleListAllOrder();
     public List<Orders> handleListAllOrderByUserId(int id);
     public List<Orders> handleListAllOrderByProductId(int id);
     public List<Orders> handleListAllOrderByDate(Date low, Date high);
     public Orders handleGetOrderById(int id);
     public int handleCreateNewOrder(Orders orders);
     public int handleUpdateOrderById(Orders orders, int id);
     public  int handleDeleteOrderId(int id);

 }
