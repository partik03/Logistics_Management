package com.logistics.web.models;

import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "Shipment")
public class Shipment {

    public enum Status{
        Preparing, Dispatched, Delivered
    };


     
    @Getter
    private int shipmentId;

     
    @Getter
    private Date shipmentDate;

     
    @Getter
    private Status status;

     
    @Getter
    private Date estimatedDeliveryDate;

     
    @Getter
    private int orderId;

    @Getter
    private int carrierId;

    @Getter
    private int warehouseId;
}

