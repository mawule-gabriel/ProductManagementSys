package com.example.productmanagementsys.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // Avoid setting the id manually
    private Long id;

    private String name;  // Ensure there's a name field

    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
