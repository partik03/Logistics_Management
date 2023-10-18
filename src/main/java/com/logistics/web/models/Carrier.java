package com.logistics.web.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
import lombok.Data;
// import lombok.NoArgsConstructor;
import lombok.Getter;

@Data
public class Carrier {
    @NotNull
    @Getter
    private int carrierId;

    @NotNull
    @Getter
    @Size(min=1, max=100)
    private String personName;

    @NotNull
    @Getter
    private int capacity;

    @NotNull
    @Getter
    @Size(min=1, max=10)
    private String contact;

    @NotNull
    @Getter
    private int empId;
}
