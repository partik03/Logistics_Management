package com.logistics.web.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OrderID;
    private DateTimeFormat OrderDate;
    private long InvoiceID;
    private long ProductID;
    private long CustomerID;
}
