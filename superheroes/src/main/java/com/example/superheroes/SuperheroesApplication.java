package com.example.superheroes;

import com.example.superheroes.practice.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {

    @Autowired
    Calculator calc;

    public static void main(String[] args) {
        SpringApplication.run(SuperheroesApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        int result = calc.addition(3, 4);
        System.out.println(result);

    }
}
