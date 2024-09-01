package com.casa.demospring.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @Setter(AccessLevel.NONE)
    @Transient
    private Set<Category> categories = new HashSet<>();

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
