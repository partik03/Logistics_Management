package com.logistics.web.dao;

import com.logistics.web.models.Shipment;
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
import java.util.Random;

@Repository
public class ShipmentDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ShipmentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addShipment(Shipment shipment){
        Random random = new Random();
        String sql = "INSERT INTO Shipment(shipmentDate,status,estimatedDeliveryDate,orderId,warehouseId,carrierId) VALUES(?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setString(2, shipment.getStatus().toString());  // status is a enum
            ps.setDate(3, Date.valueOf(LocalDate.now().plusDays(random.nextInt(10)+1)));
            ps.setInt(4,shipment.getOrderId());
            if(shipment.getWarehouseId() != 0){
                ps.setInt(5,shipment.getWarehouseId());
            }else{
                ps.setNull(5, 0);
            }
            if(shipment.getCarrierId() != 0){
                ps.setInt(6,shipment.getCarrierId());
            }else{
                ps.setNull(6, 0);
            }
            
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public Shipment getShipmentById(int id){
        String sql = "SELECT * FROM Shipment WHERE shipmentId = ?";
        Shipment shipment= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Shipment.class), id);
        return shipment;
    }

    public List<Shipment> getAllShipments(){
        String sql = "SELECT * FROM Shipment";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }

    public int deleteShipmentById(int id){
        String sql = "DELETE FROM Shipment WHERE shipmentId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateShipmentById(Shipment shipment, int id){
        String sql = "UPDATE Shipment SET shipmentDate=?, status=?, estimatedDeliveryDate=?, orderId=?, warehouseId=?, carrierId=? WHERE shipmentId = ?";
        return jdbcTemplate.update(sql,shipment.getShipmentDate(),String.valueOf(shipment.getStatus()),shipment.getEstimatedDeliveryDate(),shipment.getOrderId(),shipment.getWarehouseId(),shipment.getCarrierId(),id);
    }

    public List<Shipment> getAllShipmentsByOrderId(int id){
        String sql = "SELECT * FROM Shipment WHERE orderId = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }
    public List<Shipment> getAllShipmentsByCarrierId(int id){
        String sql = "SELECT * FROM Shipment WHERE carrierId = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }
    public List<Shipment> getAllShipmentsByUserId(int id){
        String sql = "select * from Shipment where orderId in (select orderId from Orders where userId = " + id + " );";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }

    public List<Shipment> getAllShipmentsByWarehouseId(int id){
        String sql = "SELECT * FROM Shipment WHERE warehouseId = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }

    public List<Shipment> getAllShipmentsByStatus(String status){
        String sql = "SELECT * FROM Shipment WHERE status = \"" + status+"\"";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }

    public List<Shipment> getAllShipmentsByEstimatedDeliveryDate(Date low, Date high){
        String sql = "SELECT * FROM Shipment WHERE estimatedDeliveryDate >= \"" + low + "\" AND estimatedDeliveryDate <= \"" + high + "\"";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }

    public List<Shipment> getAllShipmentsByShipmentDate(Date low, Date high){
        String sql = "SELECT * FROM Shipment WHERE shipmentDate >= \"" + low + "\" AND shipmentDate <= \"" + high + "\"";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }
}