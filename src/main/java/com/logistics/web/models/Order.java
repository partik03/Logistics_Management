package com.logistics.web.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
public class Order {

    @NotNull
    @Getter
    private int orderId;

    @NotNull
    @Getter
    private Date orderDate;

    @NotNull
    @Getter
    @Min(value=1,message = "Min quantity is 1")
    private int quantity;

    @NotNull
    @Getter
    private int productId;

    @NotNull
    @Getter
    private int customerId;
}


