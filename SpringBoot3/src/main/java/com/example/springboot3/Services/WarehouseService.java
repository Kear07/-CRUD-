package com.example.springboot3.Services;

import com.example.springboot3.Dtos.ProductDto;
import com.example.springboot3.Dtos.WarehouseDto;
import com.example.springboot3.Models.ProductModel;
import com.example.springboot3.Models.WarehouseModel;
import com.example.springboot3.Repositorys.WarehouseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    //Metodo para testar
    public String t1 (){
        return "Teste realizado com sucesso! \n\tClass: WarehouseService on!";
    }

    //Metodo Get all
    public List<WarehouseModel> Listar(){return warehouseRepository.findAll();}

    //Metodo Post
    public WarehouseModel Armazenar(WarehouseModel warehousemodel) {

        var novoArmazem = new WarehouseModel();
        BeanUtils.copyProperties(warehousemodel, novoArmazem);
        return warehouseRepository.save(novoArmazem);
    }

    //Metodo Put por ID
    public WarehouseModel AlterarID(WarehouseDto warehouseDto){
        var warehouse  = warehouseRepository.findById(warehouseDto.getId());
        if (warehouse.isEmpty()){return null;}
        WarehouseModel warehouseModel = warehouse.get();
        BeanUtils.copyProperties(warehouseDto, warehouseModel);
        return warehouseRepository.save(warehouseModel);
    }



    //Metodo Deletar por ID
    public WarehouseModel DeletarID(int id){
        var warehouse  = warehouseRepository.findById(id);
        if (warehouse.isEmpty()) {return null;}
        warehouseRepository.delete(warehouse.get());
        return warehouse.get();
    }
}

//
////Metodo Post para usar no postman etc..
//public WarehouseModel Armazenar(WarehouseModel warehouseModel){
//    var novoArmazem = new WarehouseModel();
//    BeanUtils.copyProperties(warehouseModel, novoArmazem);
//    return warehouseRepository.save(novoArmazem);
//}