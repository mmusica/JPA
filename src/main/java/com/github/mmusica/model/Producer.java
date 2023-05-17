package com.github.mmusica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "producer")
public class Producer {

    public Producer() {
    }
    public Producer(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Getter @Setter
    @OneToMany(mappedBy = "producer",orphanRemoval = true,cascade = CascadeType.ALL)
    private Set<Product> productList = new HashSet<>();

    public void addProduct(Product product){
        productList.add(product);
        product.setProducer(this);
    }
    public void removeProduct(Product product){
        productList.remove(product);
        product.setProducer(null);
    }
}
