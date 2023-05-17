package com.github.mmusica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    public Client()
    {

    }
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Getter @Setter
    @Column(name = "address", nullable = false)
    private String address;

    @Getter @Setter
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "client_products",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> productSet = new HashSet<>();

    public void addProduct(Product product){
        productSet.add(product);
        product.getClientSet().add(this);
    }
    public void removeProduct(Product product){
        productSet.remove(product);
        product.getClientSet().remove(this);
    }
}
