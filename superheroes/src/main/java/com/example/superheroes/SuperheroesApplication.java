package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication public class SuperheroesApplication implements CommandLineRunner {

	@Autowired
	HeroService heroService;

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Hero> heroes = heroService.getHeroesStartingWithLetter("C");
		for (Hero hero : heroes){
			System.out.println(hero);
		}

		System.out.println("___________________________________________");

		List<Hero> allHeroes = heroService.getAllHeroes();
		for (Hero hero : allHeroes){
			System.out.println(hero);
		}

		System.out.println("___________________________________________");

		List<Hero> lastThreeHeroes = heroService.getLastThreeHeroesByName();
		for (Hero hero : lastThreeHeroes){
			System.out.println(hero);
		}
	}
}