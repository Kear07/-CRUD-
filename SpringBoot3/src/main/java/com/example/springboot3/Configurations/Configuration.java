package com.example.springboot3.Configurations;

import org.springframework.context.annotation.Bean;

import java.util.Random;

//Serve para configurar classes externas
@org.springframework.context.annotation.Configuration
public class Configuration {

    //Aqui vc está liberando acesso para a biblioteca Random
    @Bean
    public Random randomBean() {
        return new Random();
    }


}
