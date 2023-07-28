package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.practice.Calculator;
import com.example.superheroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {

    //@Autowired
    //Calculator calc;
    @Autowired
    HeroRepository heroRepository;

    public static void main(String[] args) {
        SpringApplication.run(SuperheroesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("Hello World!");
        //int result = calc.addition(3, 4);
        //System.out.println(result);

        //List<Hero> heroes = heroRepository.findAll();
        //List<Hero> heroes = heroRepository.findTop3ByOrderByNameDesc();
        List<Hero> heroes = heroRepository.findHeroesNameStartingWithLetter("C%");
        for (Hero hero: heroes){
            System.out.println(hero);
        }
    }
}
