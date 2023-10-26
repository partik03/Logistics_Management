package com.logistics.web.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
public  class Warehouse {
     
    @Getter
    private int warehouseId;

     
    @Getter
    @Min(value=0,message="Capacity must be positive")
    private int capacity;

     
    @Getter
    @Size(min=6, max=6)
    private String pinCode;

    @Getter
    @Size(min=0, max=50)
    private String street;

    @Getter
    @Size(min=0, max=50)
    private String city;

    @Getter
    @Size(min=0, max=50)
    private String state;
}
