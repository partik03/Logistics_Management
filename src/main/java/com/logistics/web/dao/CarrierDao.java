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
        String sql = "INSERT INTO Carrier(personName,capacity,contact,empId) VALUES(?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, carrier.getPersonName());
            ps.setInt(2, carrier.getCapacity());
            ps.setString(3, carrier.getContact());
            ps.setInt(4,carrier.getEmpId());

            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public Carrier getCarrierById(int id){
        String sql = "SELECT * FROM Carrier WHERE carrierId=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Carrier.class));
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
        String sql = "UPDATE Carrier SET personName=?, capacity=?, contact=?, empId=? WHERE carrierId=?";
        return jdbcTemplate.update(sql,carrier.getPersonName(),carrier.getCapacity(),carrier.getContact(),carrier.getEmpId(),id);
    }
}
