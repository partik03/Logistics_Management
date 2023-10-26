package com.logistics.web.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
public class Product {
     
    @Getter
    private int productId;

    @Getter
    @Min(value=0,message="Weight must be positive")
    private int weight;

     
    @Getter
    @Size(min=1, max=20)
    private String productName;

    @Getter
    @Size(min=0, max=1000)
    private String description;

     
    @Getter
    private String address;

     
    @Getter
    private int userId;
}
