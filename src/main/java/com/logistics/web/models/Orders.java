package com.logistics.web.models;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
public class Orders {

     
    @Getter
    private int orderId;

    @Getter
    private String sendersName;
    
    @Getter
    private String recieversName;

    @Getter
    private String sendersEmail;

    @Getter
    private String recieversEmail;
    
    @Getter
    private int sendersPhone;

    @Getter
    private int recieversPhone;
    
    @Getter
    private String sendersAddress;

    @Getter
    private String recieversAddress;

    @Getter
    private Date orderDate;
     
    @Getter
    private int productId;

     
    @Getter
    private int userId;
}



