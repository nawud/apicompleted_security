package com.example.ecommerce_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity @Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "price")
    private double price;

    @NotNull @NotBlank
    @Size(min = 5, max = 50, message = "Product name must be between 5 and 50 characters.")
    @Column(name = "name")
    private String name;

    @URL(protocol = "https", message = "Image URL must be a valid HTTPS URL")
    @Column(name = "image_url")
    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product (

            @NotNull @NotBlank(message = "Name is required!")
            @Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters!")
            String name,

            @NotNull @Positive
            double price,

            @URL(message = "Image (URL) is required!")
            String imageURL, Optional<Category> category

    ) {}

}