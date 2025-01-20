package com.example.ecommerce_api.User.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity @Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank @NotNull
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters.")
    private String username;

    // Format yet to be implemented
    private String email;

    // Validation rule yet to be implemented
    private String password;

    // username
    // - not NULL
    // - max 50 characters

    // email
    // - format: email

    // password
    // - rule to validate

    // products (Many to Many)
    // - linked to existent users

}
