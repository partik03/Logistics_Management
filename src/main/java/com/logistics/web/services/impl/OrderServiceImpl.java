 package com.logistics.web.services.impl;

 import com.logistics.web.dao.OrderDao;
 import com.logistics.web.models.Order;
 import com.logistics.web.services.OrderService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.sql.Date;
 import java.util.List;

 @Service
 public class OrderServiceImpl implements OrderService {

      public OrderDao orderDao;
      @Autowired
      public OrderServiceImpl(OrderDao orderDao){
          this.orderDao = orderDao;
      }

      @Override
      public List<Order> handleListAllOrders(){
          return orderDao.getAllOrders();
     }

     @Override
     public Order handleGetOrderById(int id){
         return orderDao.getOrderById(id);
     }

     @Override
     public int handleCreateNewOrder(Order order){
         return orderDao.addOrder(order);
     }

     @Override
     public int handleUpdateOrderById(Order order, int id){
         return orderDao.updateOrderById(order,id);
     }

     @Override
     public  int handleDeleteOrderId(int id){
         return orderDao.deleteOrderById(id);
     }

    @Override
     public List<Order> handleListAllOrdersByUserId(int id){
          return orderDao.getAllOrdersByUserId(id);
    }

     @Override
     public List<Order> handleListAllOrdersByProductId(int id) {
         return orderDao.getAllOrdersByProductId(id);
     }

     @Override
     public List<Order> handleListAllOrdersByDate(Date low, Date high) {
         return orderDao.getAllOrdersByDate(low,high);
     }
 }
