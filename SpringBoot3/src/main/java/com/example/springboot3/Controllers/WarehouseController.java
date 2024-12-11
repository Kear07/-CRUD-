package com.example.springboot3.Controllers;

import com.example.springboot3.Dtos.WarehouseDto;
import com.example.springboot3.Models.WarehouseModel;
import com.example.springboot3.Repositorys.WarehouseRepository;
import com.example.springboot3.Services.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private WarehouseRepository warehouseRepository;

    //Criação do endpoint com sua função
    @GetMapping("/t1")
    public String t1(){return warehouseService.t1();}

    @GetMapping("/get")
    public List<WarehouseModel> get(){
        List <WarehouseModel> warehouse = warehouseService.Listar();
        if (warehouse.isEmpty()) {return null;}
        return warehouse;
    }

    //Metodo post para usar no HTML
    public WarehouseModel post(WarehouseModel warehousemodel) {
        WarehouseModel novoArmazem = new WarehouseModel();
        BeanUtils.copyProperties(warehousemodel, novoArmazem);
        WarehouseModel savedWarehouse = warehouseRepository.save(novoArmazem);
        return savedWarehouse;
    }

    ///metodo put editar
    public WarehouseModel put(WarehouseDto warehouseDto){
        return warehouseService.AlterarID(warehouseDto);
    }

    @DeleteMapping("/delete/{id}")
    public WarehouseModel delete(@PathVariable(value = "id") int id){
        var warehouse = warehouseService.DeletarID(id);
        if (warehouse == null) {return null;}
        return warehouse;
    }
}

