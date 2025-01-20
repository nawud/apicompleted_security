package com.example.ecommerce_api.Product.model;

import com.example.ecommerce_api.Category.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "products")
public class Product {
    // In Product.java
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Positive(message = "Price must be greater than 0")
    private double price;

    @NotNull
    @Size(min = 5, max = 50, message = "Product name must be between 5 and 50 characters.")
    private String name;

    @URL(protocol = "https", message = "Image URL must be a valid HTTPS URL")
    private String imageURL;


    public Product(double price, String name, String imageURL) {
        this.price = price;
        this.name = name;
        this.imageURL = imageURL;
    }
}
// name
// - not NULL
// - max 50 characters

// price
// - higher than 0

// rating (OPT)
// - Value between 0 and 5

// categoryID (Many to One)
// - linked to existent category

// userID (Many to Many)
// - linked to existent product