package com.logistics.web.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "Employee")
public class User {

    public enum Role{
        SA,A,D,WM,C
    };


    @NotNull
    @Getter
    private int userId;

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
    @Min(value=12,message = "Min Customer Age is 12")
    private int age;

    @NotNull
    @Getter
    @Size(min = 1, max=1000)
    private String address;

    @Getter
    private Date dateOfBirth;

    @NotNull
    @Getter
    private Role role;
    
}

