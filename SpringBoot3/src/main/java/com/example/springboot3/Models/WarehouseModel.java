package com.example.springboot3.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Warehouse")
public class WarehouseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int stock;

    @Column(unique = true)
    private String address;

    public WarehouseModel(int stock,String address) {
        this.stock = stock;
        this.address = address;
    }

}
