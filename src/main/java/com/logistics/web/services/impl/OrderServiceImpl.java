 package com.logistics.web.services.impl;

 import com.logistics.web.dao.OrderDao;
 import com.logistics.web.models.Order;
 import com.logistics.web.services.OrderService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.Date;
 import java.util.List;

 @Service
 public abstract class OrderServiceImpl implements OrderService {


      public OrderDao orderDao;
      @Autowired
      public OrderServiceImpl(OrderDao orderDao){
          this.orderDao = orderDao;
      }

     public List<Order> handleListAllOrders(){
          return orderDao.getAllOrders();
     }
//     public List<Order> handleListOrdersByCustomerId(int customerId);

     public Order handleGetOrderById(int id){
         return orderDao.getOrderById(id);
     }

     public int handleCreateNewOrder(Order order){
         return orderDao.addOrder(order);
     }

     public int handleUpdateOrderById(Order order, int id){
         return orderDao.updateOrderById(order,id);
     }

     public  int handleDeleteOrderId(int id){
         return orderDao.deleteOrderById(id);
     }


//     public Order modifyOrderStatus(int orderId,String status);
//
//
//
//     public List<Order> filterOrdersByData(Date date);
//
//
//     public List<Order> filterByStatus(String status);


 }
