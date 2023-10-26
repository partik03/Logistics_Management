package com.logistics.web.dao;

import com.logistics.web.models.Complaint;

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
public class ComplaintDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ComplaintDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addComplaint(Complaint complaint){
        String sql = "INSERT INTO Complaint(userId,orderId,description,email) VALUES(?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, complaint.getUserId());
            ps.setInt(2, complaint.getOrderId());
            ps.setString(3, complaint.getDescription());
            ps.setString(4, complaint.getEmail());
        
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }


    public Complaint getComplaintById(int id){
         String sql = "SELECT * FROM Complaint WHERE complaintId = ?";
        Complaint complaint = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Complaint.class),id);
        return complaint;
    }

    public List<Complaint> getAllComplaints(){
        String sql = "SELECT * FROM Complaint";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Complaint.class));
    }
    public List<Complaint> getAllComplaintsByOrderId(int id){
        String sql = "SELECT * FROM Complaint WHERE orderId =" + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Complaint.class));
    }
    public List<Complaint> getAllComplaintsByUserId(int id){
        String sql = "SELECT * FROM Complaint WHERE userId =" + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Complaint.class));
    }

    public int deleteComplaintById(int id){
        String sql = "DELETE FROM Complaint WHERE complaintId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateComplaintById(Complaint complaint, int id){
        String sql = "UPDATE Complaint SET customerId=?, orderId=?, description=?, email=? WHERE complaintId = ?";
        return jdbcTemplate.update(sql,complaint.getUserId(),complaint.getOrderId(),complaint.getDescription(),complaint.getEmail(),id);
    }

}
