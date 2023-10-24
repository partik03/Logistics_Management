    package com.logistics.web.models;

    import jakarta.validation.constraints.Min;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;
    import lombok.Data;
    import lombok.Getter;

    import java.sql.Date;

    @Data
    public class Customer {
        @NotNull
        @Getter
        private int customerID;

        @NotNull
        @Getter
        @Size(min = 8,max=100)
        private String password;

        @NotNull
        @Getter
        private String firstName;

        @Getter
        private String lastName;

        @Getter
        private String email;

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
        @Size(min=10,max=10)
        private String phone;
    }
