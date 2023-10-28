package com.logistics.web.dao;

import com.logistics.web.models.Warehouse;
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
public class WarehouseDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public WarehouseDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addWarehouse(Warehouse warehouse){
        String sql = "INSERT INTO Warehouse(capacity,pinCode,street,city,state,userId) VALUES(?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, warehouse.getCapacity());
            ps.setString(2, warehouse.getPinCode());
            ps.setString(3, warehouse.getStreet());
            ps.setString(4,warehouse.getCity());
            ps.setString(5,warehouse.getState());
            ps.setInt(6,warehouse.getUserId());
            
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public int getWarehouseByUserId(int id){
        String sql = "SELECT * FROM Warehouse WHERE userId = ?";
        Warehouse warehouse= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Warehouse.class), id);
        return warehouse.getWarehouseId();
    }

    public Warehouse getWarehouseById(int id){
        String sql = "SELECT * FROM Warehouse WHERE warehouseId = ?";
        Warehouse warehouse= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Warehouse.class), id);
        return warehouse;
    }

    public List<Warehouse> getAllWarehouses(){
        String sql = "SELECT * FROM Warehouse";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Warehouse.class));
    }

    public int deleteWarehouseById(int id){
        String sql = "DELETE FROM Warehouse WHERE warehouseId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateWarehouseById(Warehouse warehouse, int id){
        String sql = "UPDATE Warehouse SET capacity=?, pinCode=?, street=?, city=?, state=?, userId=? WHERE warehouseId = ?";
        return jdbcTemplate.update(sql,warehouse.getCapacity(),warehouse.getPinCode(),warehouse.getStreet(),warehouse.getCity(),warehouse.getState(),warehouse.getUserId(),id);
    }
}