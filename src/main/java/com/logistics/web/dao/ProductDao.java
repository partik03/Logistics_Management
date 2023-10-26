package com.logistics.web.dao;

import com.logistics.web.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addProduct(Product product){
        String sql = "INSERT INTO Product(weight,productName,description,address,userId) VALUES(?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, product.getWeight());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getDescription());
            ps.setString(4, product.getAddress());
            ps.setInt(5,product.getUserId());
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }


    public Product getProductById(int id){
         String sql = "SELECT * FROM Product WHERE productId = ?";
         Product product = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
         return product;
    }


    public List<Product> getAllProducts(){
        String sql = "SELECT * FROM Product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
    public List<Product> getAllProductsByUserId(int id){
        String sql = "SELECT * FROM Product WHERE userId = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public int deleteProductById(int id){
        String sql = "DELETE FROM Product WHERE productId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateProductById(Product product, int id){
        String sql = "UPDATE Product SET weight=?, productName=?, description=?, address=?, userId=? WHERE productId = ?";
        return jdbcTemplate.update(sql,product.getWeight(),product.getProductName(),product.getDescription(),product.getAddress(),product.getUserId(),id);
    }

}
