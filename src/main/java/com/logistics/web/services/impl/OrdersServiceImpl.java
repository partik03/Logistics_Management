 package com.logistics.web.services.impl;

 import com.logistics.web.dao.OrdersDao;
 import com.logistics.web.models.Orders;
 import com.logistics.web.services.OrdersService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.sql.Date;
 import java.util.List;

 @Service
 public class OrdersServiceImpl implements OrdersService {

      public OrdersDao orderDao;
      @Autowired
      public OrdersServiceImpl(OrdersDao orderDao){
          this.orderDao = orderDao;
      }

      @Override
      public List<Orders> handleListAllOrder(){
          return orderDao.getAllOrders();
     }

     @Override
     public Orders handleGetOrderById(int id){
         return orderDao.getOrderById(id);
     }

     @Override
     public int handleCreateNewOrder(Orders orders){
         return orderDao.addOrder(orders);
     }

     @Override
     public int handleUpdateOrderById(Orders orders, int id){
         return orderDao.updateOrderById(orders,id);
     }

     @Override
     public  int handleDeleteOrderId(int id){
         return orderDao.deleteOrderById(id);
     }

    @Override
     public List<Orders> handleListAllOrderByUserId(int id){
          return orderDao.getAllOrdersByUserId(id);
    }

     @Override
     public List<Orders> handleListAllOrderByProductId(int id) {
         return orderDao.getAllOrdersByProductId(id);
     }

     @Override
     public List<Orders> handleListAllOrderByDate(Date low, Date high) {
         return orderDao.getAllOrdersByDate(low,high);
     }
 }
