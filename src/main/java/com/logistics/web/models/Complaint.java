package com.logistics.web.models;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;


@Data
public class Complaint {
    @NotNull
    @Getter
    private int complaintId;

    @Getter
    @NotNull
    private int customerId;

    @Getter
    @NotNull
    private int orderId;

    @NotNull
    @Getter
    @Size(min=1, max=1000)
    private String description;

    @NotNull
    @Getter
    private String email;
}
