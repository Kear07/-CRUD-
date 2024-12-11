package com.example.springboot3.Controllers;
import com.example.springboot3.Dtos.ProductDto;
import com.example.springboot3.Dtos.WarehouseDto;
import com.example.springboot3.Models.ProductModel;
import com.example.springboot3.Models.WarehouseModel;
import com.example.springboot3.Repositorys.ProductRepository;
import com.example.springboot3.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/t1")
    public String t1() {return productService.Tx1();}

    @GetMapping("/get")
    public List<ProductModel> get() {

        List <ProductModel> product = productService.Listar();
        if (product.isEmpty()) {return null;}
        return product;

    }

    //Metodo post para usar no HTML
    public ProductModel post(ProductModel productmodel) {
        ProductModel novoProduto = new ProductModel();
        BeanUtils.copyProperties(productmodel, novoProduto);
        ProductModel savedProduct = productRepository.save(novoProduto);
       return savedProduct;
    }

    ///metodo put editar
    public ProductModel put(ProductDto productDto){
        return productService.AlterarID(productDto);
    }


    @DeleteMapping("/delete/{id}")
    public ProductModel delete(@PathVariable(value = "id") int id){
        var product = productService.DeletarID(id);
        if (product == null) {return null;}
        return product;

    }
}
