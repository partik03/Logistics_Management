package com.logistics.web.models;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
public class Invoice {
    public enum PaymentStatus{
        Pending,Success,Failed
    };

     
    @Getter
    private int invoiceId;

    @Getter
    private int amount;

     
    @Getter
    private PaymentStatus paymentStatus;

     
    @Getter
    private Date dateOfPublish;

    @Getter
    @Size(min=0, max=100)
    private String address;

     
    @Getter
    private int orderId;

    @Getter
    private String razorpayOrderId;
}