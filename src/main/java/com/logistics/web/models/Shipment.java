package com.logistics.web.models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "Shipment")
public class Shipment {

    public enum Status{
        Preparing,Dipatched,Delivered
    };


    @NotNull
    @Getter
    private int shipmentId;

    // @DateTimeFormat
    @NotNull
    @Getter
    private Date shipmentDate;

    @NotNull
    @Getter
    private Status status;

    // @DateTimeFormat
    @NotNull
    @Getter
    private Date estimatedDeliveryDate;

    @NotNull
    @Getter
    private int orderId;

    @NotNull
    @Getter
    private int customerId;

    @NotNull
    @Getter
    private int carrierId;
}
