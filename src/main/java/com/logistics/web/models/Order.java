package com.logistics.web.models;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
public class Order {

     
    @Getter
    private int orderId;

     
    @Getter
    private Date orderDate;

     
    @Getter
    @Min(value=1,message = "Min quantity is 1")
    private int quantity;

     
    @Getter
    private int productId;

     
    @Getter
    private int userId;
}


