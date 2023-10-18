package com.logistics.web.dao;

import com.logistics.web.models.Carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
}
