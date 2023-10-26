package com.logistics.web.models;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;


@Data
public class Complaint {
     
    @Getter
    private int complaintId;

    @Getter
     
    private int userId;

    @Getter
     
    private int orderId;

     
    @Getter
    @Size(min=1, max=1000)
    private String description;

     
    @Getter
    private String email;
}
