package com.logistics.web.dao;

import com.logistics.web.models.Shipment;
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
public class ShipmentDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ShipmentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addShipment(Shipment shipment){
        String sql = "INSERT INTO Shipment(shipmentDate,status,estimatedDeliveryDate,orderId,customerId,carrierId) VALUES(?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, shipment.getShipmentDate());
            ps.setString(2, shipment.getStatus());  // status is a enum
            ps.setDate(3, shipment.getEstimatedDeliveryDate());
            ps.setInt(4,shipment.getOrderId());
            ps.setInt(5,shipment.getCustomerId());
            ps.setInt(6,shipment.getCarrierId());
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public Shipment getShipmentById(int id){
        String sql = "SELECT * FROM Shipment WHERE shipmentId ="+id;
        List<Shipment> shipments= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
        if(shipments.isEmpty()){
            return null;
        }
        return shipments.get(0);
    }

    public List<Shipment> getAllShipments(){
        String sql = "SELECT * FROM Shipment";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shipment.class));
    }

    public int deleteShipmentById(int id){
        String sql = "DELETE FROM Shipment WHERE shipmentId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public Shipment updateShipmentById(Shipment shipment, int id){
        String sql = "UPDATE Shipment SET shipmentDate=?, status=?, estimatedDeliveryDate=?, orderId=?, customerId=?, carrierId=? WHERE shipmentId = ?";
        jdbcTemplate.update(sql,shipment.getShipmentDate(),shipment.getStatus(),shipment.getEstimatedDeliveryDate(),shipment.getOrderId(),shipment.getCustomerId(),shipment.getCarrierId(),id);
        return shipment;
    }
}