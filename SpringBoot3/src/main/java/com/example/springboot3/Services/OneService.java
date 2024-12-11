//package com.example.springboot3.Services;
//
//import com.example.Desafio.v3.Dtos.OneDto;
//import com.example.Desafio.v3.Models.OneModel;
//import com.example.Desafio.v3.Repositorys.OneRepository;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
////Aqui ficam os metodos onde o controller puxa e utilizan, em vez de fazer tudo na classe controller
//@Service
//public class OneService {
//
//    @Autowired
//    OneRepository oneRepository;
//
//    public String Pnome(String nome){
//        return "Hello " + nome;
//    }
//
//    //Metodo pra retonar conteudo da tabela
//    public List <OneModel> getAll(){
//        return oneRepository.findAll();
//    }
//
//    public OneModel postAll(OneDto oneDto){
//        var one = new OneModel();
//        BeanUtils.copyProperties(oneDto, one);
//        return oneRepository.save(one);
//    }
//
//
//    public OneModel putID(int id, OneDto oneDto){
//        var one = oneRepository.findById(id);    //Vai procurar no respository o id e retonar um optinal <oneModel>
//        OneModel oneModel = one.get();           //Ele instancia um objeto de oneModel e pega objto de oneModel dentro de one
//        BeanUtils.copyProperties(oneDto, oneModel);
//        return oneRepository.save(oneModel);
//    }
//
//    public OneModel deleteID(int id){
//        var one = oneRepository.findById(id);
//        if (one.isEmpty()) {return null;}
//        oneRepository.delete(one.get());
//        return one.get();
//    }
//
//    public OneModel patchGozei(int id, String nome){
//        var one = oneRepository.findById(id);
//        if (one.isEmpty()) {return null;}
//        one.get().setNome(nome);
//        return oneRepository.save(one.get());
//    }
//
//}
//
