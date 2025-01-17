package Product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageURL;

    public Product(
            double price,
            @NotBlank(message = "Name is required!")
            String name,
            @URL(protocol = "https", message = "Image (URL) is required!")
            String imageURL
    ) {}
}
