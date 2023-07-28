package com.example.superheroes.service;

import com.example.superheroes.model.Hero;
import com.example.superheroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> getHeroesStartingWithLetter(String letter){
        String letterParam = letter + "%";
        List<Hero> heroes = heroRepository.findHeroesNameStartingWithLetter(letterParam);
        return heroes;
    }
}
