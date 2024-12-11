package com.example.springboot3.Repositorys;

import com.example.springboot3.Models.WarehouseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository <WarehouseModel, Integer> {
}
