package com.github.mmusica.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="product")
public class Product{

    public Product() {
    }
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Getter @Setter
    @Column(name ="quantity", nullable = false)
    private int quantity;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_id", nullable = false)
    private Producer producer;
}
