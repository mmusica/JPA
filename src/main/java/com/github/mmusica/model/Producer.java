package com.github.mmusica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

}
