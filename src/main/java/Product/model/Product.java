package Product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity @Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double price;

    @NotBlank @NotNull
    @Size(min = 5, max = 50, message = "Product name must be between 5 and 50 characters.")
    private String name;

    private String imageURL;

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
}
