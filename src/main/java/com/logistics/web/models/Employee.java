package com.logistics.web.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "Employee")
public class Employee {

    public enum Role{
        SA,A,D,WM
    };


    @NotNull
    @Getter
    private int empId;

    @NotNull
    @Getter
    @Size(min=0, max=100)
    private String firstName;

    @NotNull
    @Getter
    @Size(min=0, max=100)
    private String lastName;

    @NotNull
    @Getter
    @Size(min=0, max=10)
    private String contact;

    @NotNull
    @Getter
    private Role role;
    
}
