package com.example.ecommerce_api.Category.model;

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
@Entity @Table(name = "categories")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank @NotNull
    @Size(min = 5, max = 30, message = "Category name must be between 5 and 30 characters.")
    private String name;

    // name
    // - not NULL
    // - max 30 characters

    // productID (One to Many)
    // - linked to existent products

}
