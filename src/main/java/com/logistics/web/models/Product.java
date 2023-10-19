package com.logistics.web.models;

import lombok.Data;
import lombok.Getter;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

@Data
public class Product {
    @NotNull
    @Getter
    private int productId;

    @Getter
    @Min(value=0,message="Weight must be positive")
    private int weight;

    @NotNull
    @Getter
    @Size(min=1, max=20)
    private String productName;

    @Getter
    @Size(min=0, max=100)
    private String description;

    @NotNull
    @Getter
    private int warehouseId;
}
