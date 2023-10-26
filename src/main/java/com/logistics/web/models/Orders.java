package com.logistics.web.models;

import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
public class Orders {

     
    @Getter
    private int orderId;

    @Getter
    private Date orderDate;
    
    @Getter
    private int quantity;

    @Getter
    private int productId;

    @Getter
    private int userId;
}



