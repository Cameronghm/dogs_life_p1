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
    public List<Hero> searchByLetter(String letter) {
        String statement = letter + "%";
        return heroRepository.findHeroesNameStartingWithLetter(statement);
    }
    public List<Hero> getAll()
    {
        return heroRepository.findAll();
    }
    public List<Hero> getTop3NamesDesc()
    {
        return heroRepository.findTop3ByOrderByNameDesc();
    }
    public Hero saveHero(Hero hero)
    {
        return heroRepository.save(hero);
    }
}
