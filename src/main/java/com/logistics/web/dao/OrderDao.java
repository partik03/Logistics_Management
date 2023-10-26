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
public class OrderDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addOrder(Orders orders){
        String sql = "INSERT INTO Orders(orderDate,quantity,productId,userId) VALUES(?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, orders.getQuantity());
            ps.setInt(3, orders.getProductId());
            ps.setInt(4, orders.getUserId());
        
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }


    public Orders getOrderById(int id){
         String sql = "SELECT * FROM Orders WHERE orderId = ?";
        Orders orders = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Orders.class),id);
        return orders;
    }

    public List<Orders> getAllOrders(){
        String sql = "SELECT * FROM Orders";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Orders.class));
    }

    public int deleteOrderById(int id){
        String sql = "DELETE FROM Orders WHERE orderId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateOrderById(Orders orders, int id){
        String sql = "UPDATE Orders SET orderDate=?, quantity=?, productId=?, userId=? WHERE orderId = ?";
        return jdbcTemplate.update(sql, orders.getOrderDate(), orders.getQuantity(), orders.getProductId(), orders.getUserId(),id);
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
        String sql = "SELECT * FROM Orders WHERE orderDate >= \"" + low + "\" AND orderDate <= \"" + high + "\"";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Orders.class));
    }
}
