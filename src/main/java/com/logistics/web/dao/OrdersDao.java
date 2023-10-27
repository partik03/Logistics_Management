package com.logistics.web.dao;

import com.logistics.web.models.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public class OrdersDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdersDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addOrder(Orders order){
        String sql = "INSERT INTO Orders(orderDate,sendersName,recieversName,sendersEmail,recieversEmail,sendersPhone,recieversPhone,sendersAddress,recieversAddress,productId,userId) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setString(2, order.getSendersName());
            ps.setString(3, order.getRecieversName());
            ps.setString(4, order.getSendersEmail());
            ps.setString(5, order.getRecieversEmail());
            ps.setInt(6, order.getSendersPhone());
            ps.setInt(7, order.getRecieversPhone());
            ps.setString(8, order.getSendersAddress());
            ps.setString(9, order.getRecieversAddress());
            ps.setInt(10, order.getProductId());
            ps.setInt(11, order.getUserId());
        
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }


    public Orders getOrderById(int id){
         String sql = "SELECT * FROM Orders WHERE orderId = ?";
        Orders order= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Orders.class),id);
        return order;
    }

    public List<Orders> getAllOrders(){
        String sql = "SELECT * FROM Orders";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Orders.class));
    }

    public List<Orders> getOrdersByUserId(int customerId ) {
        String sql = "SELECT * FROM Orders WHERE customerId = ?";
        List<Orders> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Orders.class),customerId);
        return orders;
    }

    public int deleteOrderById(int id){
        String sql = "DELETE FROM Orders WHERE orderId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateOrderById(Orders order, int id){
        String sql = "UPDATE Orders SET orderDate=?, sendersName = ?,recieversName = ?,sendersEmail = ?,recieversEmail = ?,sendersPhone = ?,recieversPhone = ?,sendersAddress = ?,recieversAddress = ?, productId=?, userId=? WHERE orderId = ?";
        return jdbcTemplate.update(sql,order.getOrderDate(),order.getSendersName(),order.getRecieversName(),order.getSendersEmail(),order.getRecieversEmail(),order.getSendersPhone(),order.getRecieversPhone(),order.getSendersAddress(),order.getRecieversAddress(),order.getProductId(),order.getUserId(),id);
    }

    public List<Orders> getAllOrdersByUserId(int id){
        String sql = "SELECT * FROM Orders WHERE userId = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Orders.class));
    }

    public List<Orders> getAllOrdersByProductId(int id){
        String sql = "SELECT * FROM Orders WHERE productId = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Orders.class));
    }

    public List<Orders> getAllOrdersByDate(Date low, Date high){
        String sql = "SELECT * FROM Orders WHERE orderDate >= " + low + " AND orderDate <= " + high;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Orders.class));
    }
}
