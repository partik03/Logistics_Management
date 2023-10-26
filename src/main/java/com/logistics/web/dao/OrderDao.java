package com.logistics.web.dao;

import com.logistics.web.models.Order;

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

    public int addOrder(Order order){
        String sql = "INSERT INTO Order(orderDate,quantity,productId,userId) VALUES(?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, order.getQuantity());
            ps.setInt(3, order.getProductId());
            ps.setInt(4, order.getUserId());
        
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }


    public Order getOrderById(int id){
         String sql = "SELECT * FROM Order WHERE orderId = ?";
        Order order= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Order.class),id);
        return order;
    }

    public List<Order> getAllOrders(){
        String sql = "SELECT * FROM Order";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }

    public int deleteOrderById(int id){
        String sql = "DELETE FROM Order WHERE orderId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateOrderById(Order order, int id){
        String sql = "UPDATE Order SET orderDate=?, quantity=?, productId=?, userId=? WHERE orderId = ?";
        return jdbcTemplate.update(sql,order.getOrderDate(),order.getQuantity(),order.getProductId(),order.getUserId(),id);
    }

    public List<Order> getAllOrdersByUserId(int id){
        String sql = "SELECT * FROM Order WHERE userId = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }

    public List<Order> getAllOrdersByProductId(int id){
        String sql = "SELECT * FROM Order WHERE productId = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }

    public List<Order> getAllOrdersByDate(Date low, Date high){
        String sql = "SELECT * FROM Order WHERE orderDate >= " + low + " AND orderDate <= " + high;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }
}
