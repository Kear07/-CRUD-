//package com.example.springboot3.Controllers;
//
//import com.example.Desafio.v3.Domain.User;
//import com.example.Desafio.v3.Dtos.OneDto;
//import com.example.Desafio.v3.Models.OneModel;
//import com.example.Desafio.v3.Services.OneService;
//import com.example.Desafio.v3.Services.RandomService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////ESSA É A CLASSE QUE RECEBE AS REQUISIÇÕES E RESPONDE A ELAS
//@RestController
//@RequestMapping("/home")
//
//public class OneController {
//
//    @Autowired
//    OneService oneService;
//    @Autowired
//    RandomService randomService;  // Injetando o RandomService como classe separada externa
//
//    //Metodos GET »»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
//
//    @GetMapping("/get1")  //Esse metodo atende ao GET
//    public String func1(){
//        return "Hello World";
//    }
//
//    @GetMapping("/get2")  //Esse metodo ja utiliza dados dessa propria classe
//    public String func2(){
//        return oneService.Pnome("Kear_07");
//    }
//
//    @GetMapping("/get3")  //Esse metodo utiliza uma classe/biblioteca exterior
//    public int func3(){
//        return randomService.GerarNumero();
//    }
//
//    @GetMapping("/enviar")
//    public ResponseEntity<List <OneModel>> func6(){
//        List<OneModel> sla =  oneService.getAll();
//        return ResponseEntity.ok().body(sla);
//    }
//
//
//    //Metodos POST »»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
//
//    @PostMapping("/post1")
//    public String func4(@RequestBody User body) {
//        return "Hello " + body.getNome();
//    }
//
//    @PostMapping("/{args}") //Retorna oque vc digitar no caminho
//    public String func5(@PathVariable("args") String args, @RequestBody User body) {
//        return "Hello " +  args;
//    }
//
//
////    @PostMapping("/{args2}") //Filtra e faz get do procuado
////    public String func6(@PathVariable("args2") String args,@RequestParam(value = "filter", defaultValue = "nenhum")
////    String filter, @RequestBody User body) {
////        return "Hello " +  filter;
////    }
//
//
//    @PostMapping("/receber")
//    public OneModel postNomes(@RequestBody OneDto oneDtoo) {
//        return oneService.postAll(oneDtoo);
//    }
//
//
//    //Metodos PUT »»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
//
//    @PutMapping("/alterar/{id}")
//    public OneModel putAlterar(@PathVariable(value="id") int id , @RequestBody @Valid OneDto oneDtoo) {
//        OneDto oneDto = new OneDto(id, oneDtoo.getNome(), oneDtoo.getIdade());
//        return oneService.putID(id, oneDto);
//    }
//
//
//    @DeleteMapping("/deletar/{id}")
//    public OneModel deleteAlterar(@PathVariable(value="id") int id) {
//        var one = oneService.deleteID(id);
//        if (one == null){
//            return null;
//        }
//        return one;
//    }
//
//
//}
