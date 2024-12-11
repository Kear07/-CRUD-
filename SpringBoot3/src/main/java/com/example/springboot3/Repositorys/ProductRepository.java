package com.example.springboot3.Repositorys;

import com.example.springboot3.Models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository <ProductModel, Integer> {

}
