package com.logistics.web.dao;

import com.logistics.web.models.Invoice;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.json.JSONObject;
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
public class InvoiceDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public InvoiceDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addInvoice(Invoice invoice) {
        System.out.println("This is add Invoice statement");
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_cbe0cwpLBbloTC", "Fjjc3PMGKqC8ELGkvrmxL2Jf");
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount",invoice.getAmount()*100);
            orderRequest.put("currency","INR");
            orderRequest.put("receipt", Integer.toString(invoice.getOrderId()));
            Order order = razorpay.Orders.create(orderRequest);
            JSONObject orderObject = order.toJson();
            System.out.println("try statement");
            System.out.println(orderObject.get("id"));

        String sql = "INSERT INTO Invoice(amount,paymentStatus,razorpayOrderId,dateOfPublish,address,orderId) VALUES(?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, invoice.getAmount());
            ps.setString(2, "Pending");
            ps.setString(3, orderObject.get("id").toString());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setString(5,invoice.getAddress());
            ps.setInt(6,invoice.getOrderId());
            
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    } catch (Exception e) {
            System.out.println("Error statement");
            System.err.println(0);
            return 0;
        }
        
    }

    public int paymentSuccess(String id){
        System.out.println(id);
        String sql = "UPDATE Invoice SET paymentStatus=\"Success\" WHERE razorpayOrderId=\""+id+"\"";
        return jdbcTemplate.update(sql);
    }


    public Invoice getInvoiceById(int id){
        String sql = "SELECT * FROM Invoice WHERE invoiceId = ?";
        Invoice invoice= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Invoice.class),id);
        return invoice;
    }
    public List<Invoice> getInvoiceByUserId(int id){
        String sql = "select * from Invoice where invoiceId in (select invoiceId from Orders where userId = ?)";
        List<Invoice> invoices= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Invoice.class),id);
        return invoices;
    }
    public Invoice getInvoiceByOrderId(int id){
        String sql = "SELECT * FROM Invoice WHERE orderId = ?";
        Invoice invoice = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Invoice.class),id);
        return invoice;
    }

    public List<Invoice> getAllInvoices(){
        String sql = "SELECT * FROM Invoice";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Invoice.class));
    }
    public List<Invoice> getAllInvoicesByAmount(int low, int high){
        String sql = "SELECT * FROM Invoice WHERE amount >= " + low + " AND amount <= " + high;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Invoice.class));
    }
    public List<Invoice> getAllInvoicesByDate(Date low, Date high){
        String sql = "SELECT * FROM Invoice WHERE dateOfPublish >= \"" + low + "\" AND dateOfPublish <= \"" + high +"\"";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Invoice.class));
    }

    public int deleteInvoiceById(int id){
        String sql = "DELETE FROM Invoice WHERE invoiceId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateInvoiceById(Invoice invoice, int id){
        String sql = "UPDATE Invoice SET amount=?, paymentStatus=?, dateOfPublish=?, address=?, orderId=? WHERE invoiceId = ?";
        return jdbcTemplate.update(sql,invoice.getAmount(),String.valueOf(invoice.getPaymentStatus()),invoice.getDateOfPublish(),invoice.getAddress(),invoice.getOrderId(),id);
    }
}