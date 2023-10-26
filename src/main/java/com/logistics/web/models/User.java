package com.logistics.web.models;

import jakarta.validation.constraints.Min;
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


     
    @Getter
    private int userId;

     
    @Getter
    @Size(min=1,max=50)
    private String password;

     
    @Getter
    @Size(min=1, max=50)
    private String username;

     
    @Getter
    @Size(min=0, max=100)
    private String firstName;

     
    @Getter
    @Size(min=0, max=100)
    private String lastName;

     
    @Getter
    @Size(min=0, max=10)
    private String contact;

     
    @Getter
    @Min(value=12,message = "Min Customer Age is 12")
    private int age;

     
    @Getter
    @Size(min=1, max=1000)
    private String address;

     
    @Getter
    private Date dateOfBirth;

     
    @Getter
    private Role authority;
}

