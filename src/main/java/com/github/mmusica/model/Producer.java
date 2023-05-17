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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    Long id;
    @Getter @Setter
    @Column(name = "name", nullable = false, length = 150)
    String name;

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
