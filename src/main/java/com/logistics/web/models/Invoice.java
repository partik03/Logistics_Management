package com.logistics.web.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
public class Invoice {
    @NotNull
    @Getter
    private int invoiceId;

    @Getter
    @Min(value=0,message="Weight must be positive")
    @NotNull
    private int amount;

    @NotNull
    @Getter
    @Size(min=1, max=20)
    private String paymentStatus;

    @NotNull
    @Getter
    private Date dateOfPublish;

    @Getter
    @Size(min=0, max=100)
    private String address;

    @NotNull
    @Getter
    private int orderId;
}