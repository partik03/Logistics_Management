package com.logistics.web.dao;

import com.logistics.web.models.Invoice;
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
public class InvoiceDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public InvoiceDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addInvoice(Invoice invoice){
        String sql = "INSERT INTO Invoice(amount,paymentStatus,dateOfPublish,address,orderId) VALUES(?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, invoice.getAmount());
            ps.setString(2, invoice.getPaymentStatus());
            ps.setDate(3, invoice.getDateOfPublish());
            ps.setString(4,invoice.getAddress());
            ps.setInt(5,invoice.getOrderId());
            
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public Invoice getInvoiceById(int id){
        String sql = "SELECT * FROM Invoice WHERE invoiceId ="+id;
        List<Invoice> invoices= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Invoice.class));
        if(invoices.isEmpty()){
            return null;
        }
        return invoices.get(0);
    }

    public List<Invoice> getAllInvoices(){
        String sql = "SELECT * FROM Invoice";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Invoice.class));
    }

    public int deleteInvoiceById(int id){
        String sql = "DELETE FROM Invoice WHERE invoiceId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public Invoice updateInvoiceById(Invoice invoice, int id){
        String sql = "UPDATE Invoice SET amount=?, paymentStatus=?, dateOfPublish=?, address=?, orderId=? WHERE invoiceId = ?";
        jdbcTemplate.update(sql,invoice.getAmount(),invoice.getPaymentStatus(),invoice.getDateOfPublish(),invoice.getAddress(),invoice.getOrderId(),id);
        return invoice;
    }
}