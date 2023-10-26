package com.logistics.web.models;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
public class Carrier {
     
    @Getter
    private int carrierId;

     
    @Getter
    @Size(min=1, max=100)
    private String name;

     
    @Getter
    private int capacity;

     
    @Getter
    @Size(min=1, max=20)
    private String number;

    @Getter
    private int userId;
}
