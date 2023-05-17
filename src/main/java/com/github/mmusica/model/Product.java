package com.github.mmusica.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Getter @Setter
    @Column(name ="quantity", nullable = false)
    private int quantity;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "producer_id", nullable = false)
    private Producer producer;

    @Getter @Setter
    @ManyToMany(mappedBy = "productSet")
    private Set<Client> clientSet = new HashSet<>();

    public void addProducer(Producer producer){

        this.setProducer(producer);
        producer.getProductList().add(this);
    }
}
