package com.example.springboot3.Services;

import com.example.springboot3.Dtos.ProductDto;
import com.example.springboot3.Dtos.WarehouseDto;
import com.example.springboot3.Models.ProductModel;
import com.example.springboot3.Models.WarehouseModel;
import com.example.springboot3.Repositorys.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //Metodo teste
    public String Tx1(){
        return "Teste realizado com sucesso! \n\tClass: ProductService on!";
    }

    //Metodo Get all
    public List <ProductModel> Listar(){
        return productRepository.findAll();
    }

    //Metodo Post
    public ProductModel Armazenar(ProductModel productmodel) {

        var novoProduto = new ProductModel();
        BeanUtils.copyProperties(productmodel, novoProduto);
        return productRepository.save(novoProduto);
    }

    //Metodo Put por ID
    public ProductModel AlterarID(ProductDto productDto){
        var product  = productRepository.findById(productDto.getId());
        if (product.isEmpty()){return null;}
        ProductModel productModel = product.get();
        BeanUtils.copyProperties(productDto, productModel);
        return productRepository.save(productModel);
    }


    public ProductModel DeletarID(int id){
        var product  = productRepository.findById(id);
        if (product.isEmpty()) {return null;}
        productRepository.delete(product.get());
        return product.get();
    }

}
