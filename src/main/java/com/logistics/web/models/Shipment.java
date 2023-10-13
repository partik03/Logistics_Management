package com.logistics.web.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ShipmentID;
    @DateTimeFormat
    private DateTimeFormat Date;
    private String Status;
    @DateTimeFormat
    private DateTimeFormat EstimatedDelivery;
    private long OrderID;
    private long CustomerID;
}
