package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity @Table(name = "products")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    // Falta añadir products + relación

}