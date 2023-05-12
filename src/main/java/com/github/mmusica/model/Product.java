package com.github.mmusica.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="product")
public class Product {

    public Product() {
    }

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter @Setter
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Getter @Setter
    @Column(name ="quantity", nullable = false)
    private int quantity;
}
