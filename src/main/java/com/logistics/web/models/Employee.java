package com.logistics.web.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

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
    @Size(min=1,max=50)
    private String password;

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

