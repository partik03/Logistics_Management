package com.logistics.web.models;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

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
    private LocalDate dateOfPublish;

    @Getter
    @Size(min=0, max=100)
    private String address;

    @NotNull
    @Getter
    private int orderId;
}