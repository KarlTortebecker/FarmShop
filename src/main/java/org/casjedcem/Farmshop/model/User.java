package org.casjedcem.Farmshop.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Data
    @MappedSuperclass
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userId;

        @Column(unique = true, nullable = false)
        private String userName;

//        @Email
//        @Column(nullable = false, unique = true, length = 50)
//        private String userEmail;

//        @Embedded
//        private Address userAddress;

        private String userPhone;

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Column(nullable = false)
        private String userPassword;


    }
