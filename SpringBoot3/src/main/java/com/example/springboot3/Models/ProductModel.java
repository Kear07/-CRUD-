package com.example.springboot3.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data  //Cria GET | SET | ToString | Outros
@Entity
@Table(name = "Product")
public class ProductModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private double price;

    @Column(unique = true)
    private String description;

    public ProductModel(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

}
