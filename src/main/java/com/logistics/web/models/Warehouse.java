package com.logistics.web.models;

import lombok.Data;
import lombok.Getter;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

@Data
public  class Warehouse {
    @NotNull
    @Getter
    private int warehouseId;

    @NotNull
    @Getter
    @Min(value=0,message="Capacity must be positive")
    private int capacity;

    @NotNull
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
