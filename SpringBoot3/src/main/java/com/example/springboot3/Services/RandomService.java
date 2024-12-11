package com.example.springboot3.Services;

import org.springframework.stereotype.Service;

import java.util.Random;

//Classe dedicada aos metodos com a biblioteca random
@Service

public class RandomService {

    private final Random random;

    public RandomService() {
        this.random = new Random();
    }

    public int GerarNumero() {
        return random.nextInt(100); // Retorna um número aleatório entre 0 e 99
    }


}

