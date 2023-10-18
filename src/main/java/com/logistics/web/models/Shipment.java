package com.logistics.web.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    private DateTimeFormat shipmentDate;

    @NotNull
    @Getter
    private Status status;

    // @DateTimeFormat
    @NotNull
    @Getter
    private DateTimeFormat estimatedDeliveryDate;

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
