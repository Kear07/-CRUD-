package com.example.springboot3.Controllers;

import com.example.springboot3.Dtos.ProductDto;
import com.example.springboot3.Dtos.WarehouseDto;
import com.example.springboot3.Models.ProductModel;
import com.example.springboot3.Models.WarehouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PagesController {

    @Autowired
    private ProductController productController;
    @Autowired
    private WarehouseController warehouseController;

    //Home
    @GetMapping("/")
    public String home(){return "home";}


    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-Parte de Products-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    //Home product
    @GetMapping("/product")
    public String product() {return "product";}

    //Pagina para adicionar
    @GetMapping("addProduct1")
    public String addProduct1() {return "Product/registerProduct";}

    //Metodo que adiciona
    @PostMapping("/addProduct2")
    public String addProduct2(@RequestParam String name, @RequestParam double price, @RequestParam String description){

        try {
            if (productController.post(new ProductModel(name, price, description)) != null) {return "redirect:/successProduct";}
            return "redirect:/failedProduct";
        }catch (Exception e){
            return "redirect:/failedProduct";
        }

    }

    //Metodo que visualiza
    @GetMapping("/listProducts")
    public String listProducts(Model model) {
        // Obter os produtos do ProductController
        List<ProductModel> products = productController.get();
        // Adicionar os produtos ao modelo para exibição na página
        model.addAttribute("products", products);
        return "Product/listProduct"; // Nome do arquivo HTML
    }

    //Pagina para editar product
    @GetMapping("/editProduct1")
    public String editProduct1(){return "Product/editProduct";}

    //Metodo que edit o product por id
    @PostMapping("/editProduct2")
    public String editProduct2(@RequestParam int id,  @RequestParam String name,  @RequestParam double price, @RequestParam String description) {
        if (productController.put(new ProductDto(id,name,price,description)) != null) {return "redirect:/successProduct";}
        return "redirect:/failedProduct";
    }




    ///tela do Metodo que exclui
    @GetMapping("/delete1Product")
    public String delete1Product() {return "Product/deleteProduct";}

    //Metodo que exclui de fato
    @PostMapping("/delete2Product")
    public String delete2Product(@RequestParam int id) {
        try {
            ProductModel deletedProduct = productController.delete(id);
            if (deletedProduct != null) {
                return "redirect:/successProduct"; // Página de sucesso
            }
        } catch (Exception e) {
            return "redirect:/failedWarehouse"; // Página de erro
        }
        return "redirect:/failedProduct"; // Página de erro
    }

    //Metodo no listar para excluir
    @GetMapping("/delete3Product/{id}")
    public String delete3Product(@PathVariable int id) {
        try {
            ProductModel deletedProduct = productController.delete(id);
            if (deletedProduct != null) {
                return "redirect:/listProducts"; // Redireciona para a página de sucesso
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir o produto: " + e.getMessage());
        }
        return "redirect:/failedProduct"; // Redireciona para a página de erro
    }

    //Pagina de sucesso produto
    @GetMapping("/successProduct")
    public String successProduct(){return "Product/successProduct";}

    //Pagina de erro produto
    @GetMapping("/failedProduct")
    public String failedProduct(){return "Product/failedProduct";}

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-Fim da parte product-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-










    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-Parte warehouse-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    //Home Warehouse
    @GetMapping("/warehouse")
    public String warehouse(){return "warehouse";}

    //Pagina para adicionar
    @GetMapping("/addWarehouse1")
    public String addWarehouse1(){return "Warehouse/registerWarehouse";}

    //Metodo que faz o post de adicionar
    @PostMapping("/addWarehouse2")
    public String addWarehouse(@RequestParam int stock, @RequestParam String address){

        try {
            if (warehouseController.post(new WarehouseModel(stock,address)) != null) {return "redirect:/successWarehouse";}
            return "redirect:/failedWarehouse";
        }catch (Exception e){
            return "redirect:/failedWarehouse";
        }

    }

    //Pagina onde lista os warehouses
    @GetMapping("/listWarehouses")
    public String listWarehouses(Model model) {
        // Obter os produtos do WarehouseController
        List<WarehouseModel> warehouses = warehouseController.get();
        // Adicionar os produtos ao modelo para exibição na página
        model.addAttribute("warehouses", warehouses);
        return "Warehouse/listWarehouse"; // Nome do arquivo HTML
    }

    //Pagina para editar warehouse
    @GetMapping("/editWarehouse1")
    public String editWarehouse1(){return "Warehouse/editWarehouse";}

    //Metodo que edit o warehouse por id
    @PostMapping("/editWarehouse2")
    public String editWarehouse2(@RequestParam int id, @RequestParam int stock, @RequestParam String address) {
        if (warehouseController.put(new WarehouseDto(id, stock, address)) != null) {return "redirect:/successWarehouse";}
        return "redirect:/failedWarehouse";
    }

    //Pagina para excluir
    @GetMapping("/delete1Warehouse")
    public String delete1Warehouse() {return "Warehouse/deleteWarehouse";}

    //Metodo para excluir
    @PostMapping("/delete2Warehouse")
    public String delete2Warehouse(@RequestParam int id) {
        try {
            WarehouseModel deletedWarehouse = warehouseController.delete(id);
            if (deletedWarehouse != null) {
                return "redirect:/successWarehouse"; // Página de sucesso
            }
        } catch (Exception e) {
            return "redirect:/failedWarehouse"; // Página de erro
        }
        return "redirect:/failedWarehouse"; // Página de erro
    }

    //Metodo no listar para excluir
    @GetMapping("/delete3Warehouse/{id}")
    public String delete3Warehouse(@PathVariable int id) {
        try {
            WarehouseModel deletedWarehouse = warehouseController.delete(id);
            if (deletedWarehouse != null) {
                return "redirect:/listWarehouses"; // Redireciona para a página de sucesso
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir o produto: " + e.getMessage());
        }
        return "redirect:/failedWarehouse"; // Redireciona para a página de erro
    }

    //Pagina de sucesso warehouse
    @GetMapping("/successWarehouse")
    public String successWarehouse(){return "Warehouse/successWarehouse";}

    //Pagina de erro warehouse
    @GetMapping("/failedWarehouse")
    public String failedWarehouse(){return "Warehouse/failedWarehouse";}

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-Fim da parte warehouse-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

}
