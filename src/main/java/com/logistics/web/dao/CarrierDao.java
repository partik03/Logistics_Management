package com.logistics.web.dao;

import com.logistics.web.models.Carrier;
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
public class CarrierDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarrierDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addCarrier(Carrier carrier){
        String sql = "INSERT INTO Carrier(name,capacity,number,userId) VALUES(?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, carrier.getName());
            ps.setInt(2, carrier.getCapacity());
            ps.setString(3, carrier.getNumber());
            ps.setInt(4,carrier.getUserId());

            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public Carrier getCarrierById(int id){
        String sql = "SELECT * FROM Carrier WHERE carrierId = ?";
        Carrier carrier = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Carrier.class),id);
        return carrier;
    }
    public int getCarrierIdByUserId(int id){
        String sql = "SELECT * FROM Carrier WHERE userId = ?";
        Carrier carrier = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Carrier.class),id);
        return carrier.getCarrierId();
    }

    public List<Carrier> getAllCarriers(){
        String sql = "SELECT * FROM Carrier";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Carrier.class));
    }

    public int deleteCarrierById(int id){
        String sql = "DELETE FROM Carrier WHERE carrierId=?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateCarrierById(Carrier carrier, int id){
        String sql = "UPDATE Carrier SET name=?, capacity=?, number=?, userId=? WHERE carrierId=?";
        return jdbcTemplate.update(sql,carrier.getName(),carrier.getCapacity(),carrier.getNumber(),carrier.getUserId(),id);
    }
}

