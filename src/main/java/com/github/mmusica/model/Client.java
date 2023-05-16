package com.github.mmusica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
public class Client {

    public Client()
    {

    }
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Getter @Setter
    @Column(name = "name", nullable = false, length = 150)
    String name;

    @Getter @Setter
    @Column(name = "address", nullable = false)
    String address;

}
