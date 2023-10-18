package com.logistics.web.models;

import jakarta.validation.constraints.Min;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
// import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Order {

    @NotNull
    @Getter
    private int orderId;

    @NotNull
    @Getter
    private DateTimeFormat orderDate;

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

